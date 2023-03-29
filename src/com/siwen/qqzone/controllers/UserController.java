package com.siwen.qqzone.controllers;

import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.TopicService;
import com.siwen.qqzone.service.interf.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.controllers
 * @className: UserController
 * @author: 749291
 * @description: TODO
 * @date: 2/18/2023 3:13 PM
 * @version: 1.0
 */

public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null) {
            List<UserBasic> userBasicList = userBasicService.getUserBasicList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(userBasicList);
            userBasic.setTopicList(topicList);
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);
            return "render:index";
        } else {
            return "redirect:login";
        }
    }

    public String friend(Integer friendId, HttpSession session) {
        UserBasic userBasic = userBasicService.getUserBasic(friendId);
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend", userBasic);
        return "render:index";
    }
}