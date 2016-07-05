package com.lujiahao.utils;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * Created by lujiahao on 2016/7/5.
 */
public class JdbcUtilsTest {
    @Test
    public void getConnection() throws Exception {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }

    @Test
    public void closeResource() throws Exception {

    }

}