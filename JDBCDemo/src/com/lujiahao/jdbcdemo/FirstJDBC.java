package com.lujiahao.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC第一个实例
 * Created by lujiahao
 * Created at 2016/7/4 17:03
 */
public class FirstJDBC {
    public static void main(String[] args) throws Exception {
        // 0.准备变量
        String driver = "com.mysql.jdbc.Driver";// mysql驱动实现类
        String url = "jdbc:mysql://localhost:3306/day15_db";// 确定数据库服务器地址,端口号,使用数据库
        String user = "root";// 登录名称
        String password = "1234";// 登录密码

        // 1.注册驱动
        Class.forName(driver);

        // 2.获得链接
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.获得语句执行者
        Statement st = conn.createStatement();

        // 4.发送sql语句,查询  结果相当于一个set集合,每一个成员表示数据库表中一条记录
        ResultSet rs = st.executeQuery("select * from t_user ");

        // 5.处理结果
        rs.next();// 移动到第一行
        // getXxx获取某一行的指定列或字段值  getXxx(int 列数),getXxx(String 字段名)
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String userPassword = rs.getString("password");
        System.out.printf("id:"+id+" username:"+username+" password:"+password);

        // 6.释放资源,优先关闭最后使用的
        rs.close();
        st.close();
        conn.close();
    }
}
