package com.hdsc.cloud.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsc.cloud.admin.User;
import com.hdsc.cloud.dao.UserDao;

/**
 * {@link UserService 用户服务} 提供者实现
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userDao.findAll();
    }
}
