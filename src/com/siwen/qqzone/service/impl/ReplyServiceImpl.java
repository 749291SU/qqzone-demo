package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.ReplyDao;
import com.siwen.qqzone.pojo.HostReply;
import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.service.interf.HostReplySevice;
import com.siwen.qqzone.service.interf.ReplyService;
import com.siwen.qqzone.service.interf.UserBasicService;
import com.siwen.qqzone.utils.ListUtils;

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
    public Reply getReply(Integer replyId) {
        List<Reply> replyList = replyDao.getReply(replyId);
        if (!ListUtils.listIsEmpty(replyList)) {
            Reply reply = replyList.get(0);
            packReply(reply);
            return reply;
        }
        return null;
    }

    @Override
    public List<Reply> getReplyList(Integer topicId) {
        List<Reply> replyList = replyDao.getReplyList(topicId);
        for (Reply reply : replyList) {
            packReply(reply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.addReply(reply);
    }

    @Override
    public void deleteReply(Integer replyId) {
        deleteReply(getReply(replyId));
    }

    @Override
    public void deleteReply(Reply reply) {
        HostReply hostReply = hostReplyService.getHostReply(reply);
        if (hostReply != null) {
            hostReplyService.deleteHostReply(hostReply);
        }
        replyDao.deleteReply(reply.getId());
    }

    private void packReply(Reply reply) {
        reply.setAuthor(userBasicService.getUserBasic(reply.getAuthor().getId()));
        reply.setHostReply(hostReplyService.getHostReply(reply));
    }
}
