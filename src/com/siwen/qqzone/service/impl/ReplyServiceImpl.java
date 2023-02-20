package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.ReplyDao;
import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.service.interf.HostReplySevice;
import com.siwen.qqzone.service.interf.ReplyService;
import com.siwen.qqzone.service.interf.UserBasicService;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.service.impl
 * @className: ReplyServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/20/2023 2:23 PM
 * @version: 1.0
 */

public class ReplyServiceImpl implements ReplyService {
    private ReplyDao replyDao;
    private UserBasicService userBasicService;
    private HostReplySevice hostReplyService;

    @Override
    public List<Reply> getReplyList(Topic topic) {
        List<Reply> replyList = replyDao.getReplyList(topic);
        for (Reply reply : replyList) {
            packReply(reply);
        }
        return replyList;
    }

    private void packReply(Reply reply) {
        reply.setAuthor(userBasicService.getUserBasic(reply.getAuthor().getId()));
        reply.setHostReply(hostReplyService.getHostReply(reply));
    }
}
