package com.bigjava18.web.biz.impl;

import com.bigjava18.web.bean.User;
import com.bigjava18.web.biz.UserBiz;
import com.bigjava18.web.dao.UserDao;
import com.bigjava18.web.dao.impl.UserDaoImpl;

/**
 * @Author zgp
 * @Since 2021 -04 -16 09 :27
 * @Description 用户业务逻辑层实现类
 */
public class UserBizImpl implements UserBiz {

    UserDao userDao=new UserDaoImpl();

    public boolean addUser(User user) {

        return userDao.addUser(user);
    }
}
