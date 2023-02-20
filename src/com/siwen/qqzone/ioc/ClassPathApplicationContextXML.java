package com.siwen.qqzone.ioc;

import com.siwen.qqzone.exceptions.IocException;
import com.siwen.qqzone.utils.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: JavaWeb
 * @package: siwen.ioc
 * @className: ClassPathApplicationContextXML
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 1:37 PM
 * @version: 1.0
 */

public class ClassPathApplicationContextXML implements BeanFactory {
    private Map<String, Object> beanMap = null;

    private static final String DEFAULT_APPLICATION_CONTEXT_CONF_LOCATION = "/applicationContext.xml";

    public ClassPathApplicationContextXML() {
        this(DEFAULT_APPLICATION_CONTEXT_CONF_LOCATION);
    }

    public ClassPathApplicationContextXML(String applicationContextConfPath) {
        if (StringUtils.isNull(applicationContextConfPath)) {
            throw new IocException("IOC container configuration is not specified!");
        }
        try {
            beanMap = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(getClass().getResourceAsStream(applicationContextConfPath));

            NodeList nodeList = document.getElementsByTagName("bean");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    beanMap.put(element.getAttribute("id"), Class.forName(element.getAttribute("class")).getDeclaredConstructor().newInstance());
                }
            }
            // Assembly dependencies
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList childNodes = node.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE && "property".equals(childNode.getNodeName())) {
                            Element childElement = (Element) childNode;
                            Object bean = beanMap.get(element.getAttribute("id"));
                            Field field = bean.getClass().getDeclaredField(childElement.getAttribute("name"));
                            field.setAccessible(true);
                            field.set(bean, beanMap.get(childElement.getAttribute("ref")));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new IocException("IOC container failed to initialized!");
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beanMap.get(beanId);
    }
}