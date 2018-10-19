package com.orange.service;

import com.orange.model.User;

import java.util.List;

/**
 * Created by Administrator on 2018/9/28.
 */
public interface UserService {
    boolean saveUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
    User getUserById(int id);
    User getUserByName(User user);
    User login(User user);
    List<User> getAllUser();
}
