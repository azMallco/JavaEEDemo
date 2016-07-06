package com.lujiahao.service.impl;

import com.lujiahao.dao.UserDao;
import com.lujiahao.dao.impl.UserDaoMySqlImpl;
import com.lujiahao.dao.impl.UserDaoXmlImpl;
import com.lujiahao.domain.User;
import com.lujiahao.service.UserService;

import java.util.List;

/**
 * service层
 * Created by lujiahao
 * Created at 2016/6/27 11:10
 */
public class UserServiceImpl implements UserService {
    // 将这个私有化可以防止外部访问   不能使用静态，避免后期出现并发的问题
    private UserDao userDao = new UserDaoMySqlImpl();
    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    @Override
    public List<User> findAllUser() {
        List<User> allUser = userDao.findAll();
        return allUser;
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findUserById(String id) {
        User user = userDao.findById(id);
        return user;
    }

    /**
     * 注册
     * @param user
     */
    @Override
    public void register(User user) {
        userDao.save(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.find(user.getUsername(),user.getPassword());
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public int editUser(User user) {
        return userDao.update(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUser(String id) {
        return userDao.delete(id);
    }
}
