package com.siwen.qqzone.service.interf;

import com.siwen.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicService {
    // get userBasic by specified loginId and pwd
    UserBasic login(String loginId, String pwd);

    // get friendList of specified userBaisic
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    // get userBasic by specified id
    UserBasic getUserBasic(Integer id);
}
