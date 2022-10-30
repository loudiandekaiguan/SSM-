package com.lyf.service.impl;

import com.lyf.dao.UserDao;
import com.lyf.domain.User;
import com.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
