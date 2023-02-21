package com.siwen.qqzone.controllers;

import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.TopicService;

import javax.servlet.http.HttpSession;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.controllers
 * @className: TopicController
 * @author: 749291
 * @description: TODO
 * @date: 2/20/2023 2:14 PM
 * @version: 1.0
 */

public class TopicController {
    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {
        session.setAttribute("topic", topicService.getTopic(id));
        return "render:frames/detail";
    }

    public String deleteTopic(Integer id, HttpSession session) {
        topicService.deleteTopic(id);
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        userBasic.setTopicList(topicService.getTopicList(userBasic));
        return "redirect:user.do?operate=friend&friendId=" + userBasic.getId();
//        return "redirect:page.do?opearte=page"
    }
}