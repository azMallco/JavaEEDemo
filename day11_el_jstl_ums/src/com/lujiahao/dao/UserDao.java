package com.lujiahao.dao;

import com.lujiahao.domain.User;

import java.util.List;

/**
 * Created by ljh on 2016/12/5.
 */
public class UserDao {
    /**
     * 添加用户
     * @param user
     */
    public void save(User user){}

    /**
     * 更新用户
     * @param user
     */
    public void update(User user){}

    /**
     * 删除用户
     * @param id
     */
    public void delete(String id){}

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll(){
        return null;
    }

    /**
     * 通过唯一标识查询
     * @param id
     * @return
     */
    public User findById(String id){
        return null;
    }

}
