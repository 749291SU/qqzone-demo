package com.siwen.qqzone.dao.impl;

import com.siwen.qqzone.dao.base.BaseDao;
import com.siwen.qqzone.dao.interf.HostReplyDao;
import com.siwen.qqzone.pojo.HostReply;
import com.siwen.qqzone.pojo.Reply;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.dao.impl
 * @className: HostReplyDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:21 PM
 * @version: 1.0
 */

public class HostReplyDaoImpl extends BaseDao<HostReply> implements HostReplyDao {
    @Override
    public HostReply getHostReply(Reply reply) {
        String sql = "SELECT * FROM t_host_reply\n" +
                "WHERE reply = ?";
        List<HostReply> hostReplyList = super.query(sql, reply.getId());
        if (hostReplyList != null && !hostReplyList.isEmpty()) {
            return hostReplyList.get(0);
        }
        return null;
    }

    @Override
    public Integer addHostReply(HostReply hostReply) {
        String sql = "INSERT INTO t_host_reply(id, content, hostReplyDate, author, reply)\n" +
                "VALUES(?, ?, ?, ?, ?)";
        return super.update(sql, hostReply.getId(), hostReply.getHostReplyDate(), hostReply.getAuthor(), hostReply.getReply());
    }

    @Override
    public Integer deleteHostReply(Integer id) {
        String sql = "DELETE FROM t_host_reply\n" +
                "WHERE id = ?";
        return super.update(sql, id);
    }
}