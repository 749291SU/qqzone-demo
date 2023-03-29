package com.siwen.qqzone.dao.impl;

import com.siwen.myssm.basedao.BaseDao;
import com.siwen.qqzone.dao.interf.ReplyDao;
import com.siwen.qqzone.pojo.Reply;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.dao.impl
 * @className: ReplyDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:20 PM
 * @version: 1.0
 */

public class ReplyDaoImpl extends BaseDao<Reply> implements ReplyDao {
    @Override
    public List<Reply> getReply(Integer replyId) {
        String sql = "SELECT * FROM t_reply\n" +
                "WHERE id = ?";
        return super.query(sql, replyId);
    }

    @Override
    public List<Reply> getReplyList(Integer topicId) {
        String sql = "SELECT * FROM t_reply\n" +
                "WHERE topic = ?";
        return super.query(sql, topicId);
    }

    @Override
    public Integer addReply(Reply reply) {
        String sql = "INSERT INTO t_reply(content, replyDate, author, topic)\n" +
                "VALUES(?, ?, ?, ?)";
        return super.update(sql, reply.getContent(), reply.getReplyDate().toString(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public Integer deleteReply(Integer replyId) {
        String sql = "DELETE FROM t_reply\n" +
                "WHERE id = ?";
        return super.update(sql, replyId);
    }
}