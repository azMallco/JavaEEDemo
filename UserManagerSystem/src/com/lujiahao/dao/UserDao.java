package com.lujiahao.dao;

import com.lujiahao.domain.User;

import java.util.List;

/**
 * 对数据进行增删改查
 *  提供5个方法(添加/更新/删除/查询所有/通过唯一标示查询)
 * Created by lujiahao
 * Created at 2016/6/24 17:16
 */
public class UserDao {
    /**
     * 添加方法
     * @param user 用户bean
     */
    public void save(User user){

    }

    /**
     * 更新(编辑)
     * @param user
     */
    public void update(User user){

    }

    /**
     * 删除
     * @param id 用户id
     */
    public void delete(String id){

    }

    /**
     * 查询所有用户信息
     * @return 所有用户信息集合
     */
    public List<User> findAll(){
        return null;
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return 查询的用户信息
     */
    public User findById(String id){
        return null;
    }
}
