package com.orange.dao;

import com.orange.model.User;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface UserDao {
    List<User> getAllUser();
    User getUserById(User user);
    User getUserByName(User user);
    User getUserByNameAndPass(User user);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
