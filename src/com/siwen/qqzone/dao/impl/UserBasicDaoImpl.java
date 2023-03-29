package com.siwen.qqzone.dao.impl;

import com.siwen.myssm.basedao.BaseDao;
import com.siwen.qqzone.dao.interf.UserBasicDao;
import com.siwen.qqzone.pojo.UserBasic;
import com.siwen.myssm.utils.ListUtils;

import java.util.List;

/**
 * @projectName: JavaWeb
 * @package: com.siwen.qqzone.dao.impl
 * @className: UserBasicDaoImpl
 * @author: 749291
 * @description: TODO
 * @date: 2/17/2023 9:19 PM
 * @version: 1.0
 */

public class UserBasicDaoImpl extends BaseDao<UserBasic> implements UserBasicDao {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        String sql = "SELECT * FROM t_user_basic\n" +
                "WHERE loginId = ?\n" +
                "AND pwd = ?";
        List<UserBasic> userBasicList = super.query(sql, loginId, pwd);
        if (userBasicList != null && !userBasicList.isEmpty()) {
            return userBasicList.get(0);
        }
        return null;
    }

    @Override
    public UserBasic getUserBasic(Integer id) {
        String sql = "SELECT * FROM t_user_basic\n" +
                "WHERE id = ?";
        List<UserBasic> userBasicList = super.query(sql, id);
        if (!ListUtils.listIsEmpty(userBasicList)) {
            return userBasicList.get(0);
        }
        return null;
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "select tub.* from t_user_basic tub\n" +
                "join t_friend tf\n" +
                "where tf.uid = ?\n" +
                "and tf.fid = tub.id;";
        return super.query(sql, userBasic.getId());
    }
}