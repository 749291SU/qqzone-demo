package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;

import java.util.List;

public interface ReplyDao {
    // get reply List of specified topic
    List<Reply> getReplyList(Topic topic);

    // add reply
    Integer addReply(Reply reply);

    // delete reply
    Integer deleteReply(Integer id);
}
