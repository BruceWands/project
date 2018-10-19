package com.orange.service.impl;

import com.orange.dao.UserDao;
import com.orange.model.User;
import com.orange.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean saveUser(User user) {
        if (user == null){
            return false;
        }
        userDao.saveUser(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null){
            return false;
        }
        userDao.updateUser(user);
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        if (user == null){
            return false;
        }
        userDao.deleteUser(user);
        return true;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        user.setId(id);
        return userDao.getUserById(user);
    }

    @Override
    public User getUserByName(User user) {
        if (user == null){
            return null;
        }
        return userDao.getUserByName(user);
    }

    @Override
    public User login(User user) {
        if (user == null){
            return null;
        }
        return userDao.getUserByNameAndPass(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
