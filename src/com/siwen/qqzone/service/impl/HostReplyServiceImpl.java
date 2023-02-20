package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.HostReplyDao;
import com.siwen.qqzone.pojo.HostReply;
import com.siwen.qqzone.pojo.Reply;
import com.siwen.qqzone.service.interf.HostReplySevice;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.service.impl
 * @className: HostReplyServiceImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/20/2023 3:40 PM
 * @version: 1.0
 */

public class HostReplyServiceImpl implements HostReplySevice {
    private HostReplyDao hostReplyDao;

    @Override
    public HostReply getHostReply(Reply reply) {
        return hostReplyDao.getHostReply(reply);
    }
}
