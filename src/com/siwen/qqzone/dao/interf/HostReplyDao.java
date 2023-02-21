package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.HostReply;

public interface HostReplyDao {
    // get hostReply of specified replyId
    HostReply getHostReply(Integer replyId);

    // add hostReply
    Integer addHostReply(HostReply hostReply);

    // delete hostReply
    Integer deleteHostReply(Integer id);
}
