package com.lujiahao.service;

import com.lujiahao.dao.UserDao;
import com.lujiahao.domain.User;

import java.util.List;

/**
 * service层
 * Created by lujiahao
 * Created at 2016/6/27 11:10
 */
public class UserService {
    // 将这个私有化可以防止外部访问   不能使用静态，避免后期出现并发的问题
    private UserDao userDao = new UserDao();
    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    public List<User> findAllUser() {
        List<User> allUser = userDao.findAll();
        return allUser;
    }
}
