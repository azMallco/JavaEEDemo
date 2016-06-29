package com.lujiahao.dao;

import com.lujiahao.domain.User;

import java.util.List;

/**
 * Created by lujiahao on 2016/6/29.
 */
public interface UserDao {
    void save(User user);

    User update(User user);

    User delete(String id);

    List<User> findAll();

    User findById(String id);

    User find(String username, String password);
}
