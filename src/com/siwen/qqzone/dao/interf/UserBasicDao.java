package com.siwen.qqzone.dao.interf;

import com.siwen.qqzone.pojo.UserBasic;

import java.util.List;

public interface UserBasicDao {
    // get user by specified loginId and pwd
    UserBasic getUserBasic(String loginId, String pwd);

    // get friend userBasic List by specified userBasic
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    // get userBasic by specified id
    UserBasic getUserBasic(Integer id);
}