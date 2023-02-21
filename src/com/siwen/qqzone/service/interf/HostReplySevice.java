package com.siwen.qqzone.service.interf;

import com.siwen.qqzone.pojo.HostReply;
import com.siwen.qqzone.pojo.Reply;

public interface HostReplySevice {
    // get host-reply of specified replyId
    HostReply getHostReply(Reply reply);

    void deleteHostReply(HostReply hostReply);
}