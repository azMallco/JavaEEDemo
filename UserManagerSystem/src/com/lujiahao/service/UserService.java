package com.lujiahao.service;

import com.lujiahao.domain.User;

import java.util.List;

/**
 * Created by lujiahao on 2016/6/29.
 */
public interface UserService {
    List<User> findAllUser();

    User findUserById(String id);

    void register(User user);

    User login(User user);

    int editUser(User user);

    int deleteUser(String id);
}
