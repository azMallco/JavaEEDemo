package com.lujiahao.crud;

import com.lujiahao.utils.JdbcUtils;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 增删改查的测试类
 * Created by lujiahao on 2016/7/5.
 */
public class CrudDemo {

    public void save() throws Exception {
        DriverManager.registerDriver(new Driver());
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15_db", "root", "1234");
        // 3.语句执行者
        Statement st = conn.createStatement();
        // 4.执行dml语句
        int i = st.executeUpdate("insert into t_user(username,password) values('haha','4321')");
        // 5.处理数据
        System.out.println("影响的行数:"+i);
        // 6.释放资源
        st.close();
        conn.close();
    }

    public void delete() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15_db", "root", "1234");
        // 3.获得语句执行者
        Statement st = conn.createStatement();
        // 4.执行删除语句
        boolean isSuccess = st.execute("delete from t_user where username='haha'");
        // 5.处理数据
        if (isSuccess){
            System.out.println("删除成功"+isSuccess);
        } else {
            System.out.println("删除失败"+isSuccess);
        }
        // 6.释放资源
        st.close();
        conn.close();
    }

    public void update() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15_db", "root", "1234");
        // 3.获得语句执行者
        Statement st = conn.createStatement();
        // 4.执行语句
        int i = st.executeUpdate("update t_user set username='lujiahao' where id=3");
        // 5.处理结果
        System.out.println("更新行数:"+i);
        // 6.释放资源
        st.close();
        conn.close();
    }

    public void findAll() throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day15_db", "root", "1234");
        // 3.获得语句执行者
        Statement st = conn.createStatement();
        // 4.执行查询语句
        ResultSet rs = st.executeQuery("select * from t_user");
        // 5.处理数据
        // 查询多个数据使用while循环
        // 如果查询至多一条,使用if(rs.next()){查询的数据}
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println("username:"+username+"  password:"+password);
        }
        // 6.释放资源
        rs.close();
        st.close();
        conn.close();
    }

    // 模板代码
    public void demo1(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            // ....
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            // 释放资源
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}
