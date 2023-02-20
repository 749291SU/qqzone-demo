package com.siwen.qqzone.listeners;

import com.siwen.qqzone.ioc.ClassPathApplicationContextXML;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @projectName: JavaWeb
 * @package: siwen.listeners
 * @className: ServletLoadLIstener
 * @author: 749291
 * @description: TODO
 * @date: 2/15/2023 4:42 PM
 * @version: 1.0
 */

@WebListener
public class ServletLoadLIstener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("beanFactory", new ClassPathApplicationContextXML(
                servletContext.getInitParameter("applicationContextConfLocation")
        ));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}