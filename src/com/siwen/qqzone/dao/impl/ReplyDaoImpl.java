package com.siwen.qqzone.dao.impl;

import com.siwen.qqzone.dao.base.BaseDao;
import com.siwen.qqzone.dao.interf.ReplyDao;
import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;

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
    public List<Reply> getReplyList(Topic topic) {
        String sql = "SELECT * FROM t_reply\n" +
                "WHERE topic = ?";
        return super.query(sql, topic.getId());
    }

    @Override
    public Integer addReply(Reply reply) {
        String sql = "INSERT INTO t_reply(id, content, replyDate, author, topic)\n" +
                "VALUES(?, ?, ?, ?, ?)";
        return super.update(sql, reply.getId(), reply.getContent(), reply.getReplyDate(), reply.getAuthor(), reply.getTopic());
    }

    @Override
    public Integer deleteReply(Integer id) {
        String sql = "DELETE FROM t_reply\n" +
                "WHERE id = ?";
        return super.update(sql, id);
    }
}