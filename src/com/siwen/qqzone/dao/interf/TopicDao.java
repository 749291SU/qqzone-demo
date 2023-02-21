package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.dao.interf
 * @className: TopicDao
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:14 PM
 * @version: 1.0
 */

public interface TopicDao {
    // get all topics by specified userBasic
    List<Topic> getTopicList(UserBasic userBasic);

    // add topic
    Integer addTopic(Topic topic);

    // delete topic
    Integer deleteTopic(Integer topicId);

    // get details of specified topic
    Topic getTopic(Integer id);
}
