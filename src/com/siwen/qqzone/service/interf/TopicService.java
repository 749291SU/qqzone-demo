package com.siwen.qqzone.service.interf;

import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;

import java.util.List;

public interface TopicService {
    List<Topic> getTopicList(UserBasic userBasic);
}
