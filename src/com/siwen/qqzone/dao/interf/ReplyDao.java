package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.Reply;

import java.util.List;

public interface ReplyDao {
    List<Reply> getReply(Integer replyId);
    // get reply List of specified topicId
    List<Reply> getReplyList(Integer topicId);

    // add reply
    Integer addReply(Reply reply);

    // delete reply
    Integer deleteReply(Integer replyId);
}
