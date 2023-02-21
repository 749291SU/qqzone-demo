package com.siwen.qqzone.service.interf;

import com.siwen.qqzone.pojo.Reply;

import java.util.List;

public interface ReplyService {
    // get all replies of specified topic
    Reply getReply(Integer replyId);

    List<Reply> getReplyList(Integer topicId);

    // add reply
    void addReply(Reply reply);

    // delete reply
    void deleteReply(Integer replyId);

    void deleteReply(Reply reply);
}
