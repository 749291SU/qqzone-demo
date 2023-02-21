package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.TopicDao;
import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.ReplyService;
import com.siwen.qqzone.service.interf.TopicService;
import com.siwen.qqzone.service.interf.UserBasicService;
import com.siwen.qqzone.utils.ListUtils;

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
    private UserBasicService userBasicService;
    private ReplyService replyService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        List<Topic> topicList = topicDao.getTopicList(userBasic);
        for (Topic topic : topicList) {
            packTopic(topic);
        }
        return topicList;
    }

    @Override
    public Topic getTopic(Integer topicId) {
        Topic topic = topicDao.getTopic(topicId);
        packTopic(topic);
        return topic;
    }

    @Override
    public void deleteTopic(Integer topicId) {
        Topic topic = getTopic(topicId);
        if (topicId != null) {
            List<Reply> replyList = topic.getReplyList();
            if (!ListUtils.listIsEmpty(replyList)) {
                for (Reply reply : replyList) {
                    replyService.deleteReply(reply);
                }
            }
            topicDao.deleteTopic(topic.getId());
        }
    }

    private void packTopic(Topic topic) {
        topic.setAuthor(userBasicService.getUserBasic(topic.getAuthor().getId()));
        topic.setReplyList(replyService.getReplyList(topic.getId()));
    }
}