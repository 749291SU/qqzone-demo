package com.siwen.qqzone.controllers;

import com.siwen.qqzone.pojo.Topic;
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
        Topic topic = topicService.getTopic(id);
        session.setAttribute("topic", topic);
//        session.setAttribute("curMain", "frames/detail");
        return "render:frames/detail";
    }
}