package com.siwen.qqzone.controllers;


import com.siwen.qqzone.exceptions.DispatchedControllerException;
import com.siwen.qqzone.ioc.BeanFactory;
import com.siwen.qqzone.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**
 * @projectName: JavaWeb
 * @package: siwen.controllers
 * @className: DispatchedController
 * @author: 749291
 * @description: TODO
 * @date: 2/10/2023 10:25 PM
 * @version: 1.0
 */

@WebServlet("*.do")
public class DispatchedController extends ViewBaseController {
    private BeanFactory beanFactory;

    @Override
    public void init() {
        super.init();
        beanFactory = (BeanFactory) getServletContext().getAttribute("beanFactory");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String controllerPath = req.getServletPath();
        String controllerName = controllerPath.substring(1, controllerPath.length() - 3);
        Object controllerInstance = beanFactory.getBean(controllerName);

        String operate = req.getParameter("operate");
        if (StringUtils.isNull(operate)) {
            operate = "page";
        }

        try {
            Method[] methods = controllerInstance.getClass().getDeclaredMethods();
            Method toInvokeMethod = null;
            for (Method method : methods) {
                if (method.getName().equals(operate)) {
                    toInvokeMethod = method;
                    break;
                }
            }
            Parameter[] parameters = toInvokeMethod.getParameters();
            Object[] parameterValues = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String parameterName = parameter.getName();
                if ("req".equals(parameterName)) {
                    parameterValues[i] = req;
                } else if ("resp".equals(parameterName)) {
                    parameterValues[i] = resp;
                } else if ("session".equals(parameterName)) {
                    parameterValues[i] = req.getSession();
                } else {
                    String type = parameter.getType().getName();
                    String tmpParameterValue = req.getParameter(parameters[i].getName());
                    if (tmpParameterValue == null) {
                        parameterValues[i] = null;
                    } else {
                        parameterValues[i] = Class.forName(type).getDeclaredConstructor(String.class).newInstance(tmpParameterValue);
                    }
                }
            }

            toInvokeMethod.setAccessible(true);
            Object methodReturnObj = toInvokeMethod.invoke(controllerInstance, parameterValues);
            String methodReturnStr = (String) methodReturnObj;

            if (methodReturnStr.startsWith("redirect:")) {
                resp.sendRedirect(methodReturnStr.substring(9));
            } else if (methodReturnStr.startsWith("render:")) {
                super.processTemplate(methodReturnStr.substring(7), req, resp);
            } else if ("error".equals(methodReturnStr)) {
                super.processTemplate("error", req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DispatchedControllerException("DispatchedController encountered mistakes");
        }
    }
}