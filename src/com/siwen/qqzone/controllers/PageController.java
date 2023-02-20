package com.siwen.qqzone.controllers;

import com.siwen.qqzone.utils.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.controllers
 * @className: PageController
 * @author: 749291
 * @description: TODO
 * @date: 2/18/2023 7:45 PM
 * @version: 1.0
 */

public class PageController {
    public String page(HttpServletRequest req, HttpServletResponse resp) {
        String page = req.getParameter("page");
        if (StringUtils.isNull(page)) {
            page = "login";
        }
        return "render:" + page;
    }
}
