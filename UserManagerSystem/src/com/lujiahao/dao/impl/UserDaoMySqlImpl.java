package com.lujiahao.dao.impl;

import com.lujiahao.dao.UserDao;
import com.lujiahao.domain.User;
import com.lujiahao.utils.JdbcUtils;
import com.lujiahao.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对数据进行增删改查
 * 提供5个方法(添加/更新/删除/查询所有/通过唯一标示查询)
 * Created by lujiahao
 * Created at 2016/6/24 17:16
 */
public class UserDaoMySqlImpl implements UserDao {

    /**
     * 添加方法
     *
     * @param user 用户bean
     */
    @Override
    public void save(User user) {
        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user(id,username,password,gender,age) values(?,?,?,?,?)";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,user.getId());
            psmt.setString(2,user.getUsername());
            psmt.setString(3,user.getPassword());
            psmt.setString(4,user.getGender());
            psmt.setString(5,user.getAge());
            int i = psmt.executeUpdate();

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt);
        }
    }

    /**
     * 更新(编辑)
     *
     * @param user
     */
    @Override
    public int update(User user) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update user set username=?,password=?,gender=?,age=? where id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,user.getUsername());
            psmt.setString(2,user.getPassword());
            psmt.setString(3,user.getGender());
            psmt.setString(4,user.getAge());
            psmt.setString(5,user.getId());
            psmt.executeUpdate();
            return psmt.getUpdateCount();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt,rs);
        }
    }



    /**
     * 删除
     *
     * @param id 用户id
     */
    @Override
    public int delete(String id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from user where id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.executeUpdate();
            return psmt.getUpdateCount();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt,rs);
        }
    }

    /**
     * 查询所有用户信息
     * 思想:一般dao层如果出现异常,都是自己进行try catch,但是需要通知调用dao方法的地方,通常是throw RuntimeException/自定义异常
     * @return 所有用户信息集合
     */
    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user";
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()){
                list.add(resultSetToUser(rs));
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt,rs);
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 查询的用户信息
     */
    @Override
    public User findById(String id) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,id);
            psmt.execute();
            rs = psmt.getResultSet();
            if (rs.next()){
                return resultSetToUser(rs);
            }
            return null;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt,rs);
        }
    }



    /**
     * 通过用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Override
    public User find(String username, String password) {
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from user where username=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,username);
            psmt.setString(2,password);
            int i = psmt.executeUpdate();
            rs = psmt.getResultSet();
            if (rs.next()){
                return resultSetToUser(rs);
            }
            return null;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,psmt,rs);
        }
    }

    private User resultSetToUser(ResultSet rs) throws SQLException {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String gender = rs.getString("gender");
        String age = rs.getString("age");

        // 封装javabean
        User user = new User(id,username,password,gender,age);
        return user;
    }
}
