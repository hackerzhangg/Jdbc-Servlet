package com.bigjava18.web.dao.impl;

import com.bigjava18.web.bean.User;
import com.bigjava18.web.common.SimpleDBUtil;
import com.bigjava18.web.dao.UserDao;

/**
 * @Author zgp
 * @Since 2021 -04 -16 09 :28
 * @Description 用户业务逻辑层实现类
 */
public class UserDaoImpl implements UserDao {

    //添加用户语句
    private static final String ADDUSERSQL="insert into user (username,password) values(?,?)";

    public boolean addUser(User user) {

        if(SimpleDBUtil.executeUpdate(ADDUSERSQL,new String[]{user.getUsername(),user.getPassword()})>0){

            return true;
        }
        return false;
    }
}
