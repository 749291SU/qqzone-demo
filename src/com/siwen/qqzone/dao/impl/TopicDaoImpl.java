package com.siwen.qqzone.dao.impl;

import com.siwen.qqzone.dao.base.BaseDao;
import com.siwen.qqzone.dao.interf.TopicDao;
import com.siwen.qqzone.pojo.Topic;
import com.siwen.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.dao.impl
 * @className: TopicDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:20 PM
 * @version: 1.0
 */

public class TopicDaoImpl extends BaseDao<Topic> implements TopicDao {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        String sql = "SELECT * FROM t_topic\n" +
                "WHERE author = ?";
        return super.query(sql, userBasic.getId());
    }

    @Override
    public Integer addTopic(Topic topic) {
        String sql = "INSERT INTO t_topic(id, title, content, topicDate, author)\n" +
                "values (?, ?, ?, ?, ?)";
        return super.update(sql, topic.getId(), topic.getTitle(), topic.getContent(), topic.getTopicDate(), topic.getAuthor());
    }

    @Override
    public Integer deleteTopic(Integer topicId) {
        String sql = "DELETE FROM t_topic\n" +
                "WHERE id = ?";
        return super.update(sql, topicId);
    }

    @Override
    public Topic getTopic(Integer id) {
        String sql = "SELECT * FROM t_topic\n" +
                "WHERE id = ?";
        List<Topic> topicList = super.query(sql, id);
        if (topicList != null && !topicList.isEmpty()) {
            return topicList.get(0);
        }
        return null;
    }
}