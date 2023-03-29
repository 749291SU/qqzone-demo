package com.siwen.qqzone.controllers;

import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.controllers
 * @className: ReplyController
 * @author: 749291
 * @description: TODO
 * @date: 2/21/2023 12:53 PM
 * @version: 1.0
 */

public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, HttpSession session) {
        Reply reply = new Reply(null, (Topic) session.getAttribute("topic"), (UserBasic) session.getAttribute("userBasic"),
                content, LocalDateTime.now(), null);
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id=" + reply.getTopic().getId();
    }

    public String deleteReply(Integer replyId, HttpSession session) {
        replyService.deleteReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id=" + ((Topic) session.getAttribute("topic")).getId();
    }
}