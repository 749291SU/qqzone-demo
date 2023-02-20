package com.siwen.qqzone.service.impl;

import com.siwen.qqzone.dao.interf.UserBasicDao;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.qqzone.service.interf.UserBasicService;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.service
 * @className: UserBasicService
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:58 PM
 * @version: 1.0
 */

public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDao userBasicDao;

    @Override
    public UserBasic login(String loginId, String pwd) {
        return userBasicDao.getUserBasic(loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        return userBasicDao.getUserBasicList(userBasic);
    }

    @Override
    public UserBasic getUserBasic(Integer id) {
        return userBasicDao.getUserBasic(id);
    }
}