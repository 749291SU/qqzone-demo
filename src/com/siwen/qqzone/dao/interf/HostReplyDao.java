package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.HostReply;
import com.siwen.qqzone.pojo.Reply;

public interface HostReplyDao {
    // get hostReply of specified reply
    HostReply getHostReply(Reply reply);

    // add hostReply
    Integer addHostReply(HostReply hostReply);

    // delete hostReply
    Integer deleteHostReply(Integer id);
}
