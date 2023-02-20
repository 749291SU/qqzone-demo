package com.siwen.qqzone.service.interf;

import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyService {
    // get all replies of specified topic
    List<Reply> getReplyList(Topic topic);
}
