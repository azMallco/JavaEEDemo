package com.lujiahao.utils;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类
 * Created by lujiahao on 2016/7/5.
 */
public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;

    // 这些配置文件的东西只用加载一次就可以了,写在静态代码块中
    static {
        try {
            InputStream is = JdbcUtils.class.getResourceAsStream("/jdbcInfo.properties");
            // 2. 解析配置文件
            Properties properties = new Properties();
            properties.load(is);
            // 3. 获得配置文件中的数据
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            // 4. 注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获得连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            // 将编译时异常转换成运行时异常,开发中常见运行时异常
            throw new RuntimeException(e);
        }
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeResource(conn,st);
        }
    }

    public static void closeResource(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
