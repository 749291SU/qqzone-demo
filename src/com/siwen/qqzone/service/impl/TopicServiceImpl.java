package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.TopicDao;
import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.TopicService;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.service.impl
 * @className: TopicServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 10:08 PM
 * @version: 1.0
 */

public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDao.getTopicList(userBasic);
    }
}