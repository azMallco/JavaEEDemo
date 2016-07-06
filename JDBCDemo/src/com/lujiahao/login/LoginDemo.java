package com.lujiahao.login;

import com.lujiahao.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lujiahao on 2016/7/6.
 */
public class LoginDemo {

    @Test
    public void demo1(){
        String username = "jack";
        String password = "1234";
        User user = find(username,password);
        System.out.println(user);
    }

    public User find(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from t_user where username = '"+username+"' and password = '"+password+"'");
            if (rs.next()){
                int id = rs.getInt("id");
                String _username = rs.getString("username");
                String _password = rs.getString("password");
                return new User(id,_username,_password);
            }
        return null;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResource(conn,st,rs);
        }
    }
}
