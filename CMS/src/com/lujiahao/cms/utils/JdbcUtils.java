package com.lujiahao.cms.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;


/**
 * 连接池工具类
 * Created by lujiahao on 2016/7/19.
 */
public class JdbcUtils {

    /**
     * 定义一个连接池
     */
    private static DataSource dataSource = new ComboPooledDataSource("day17_cms_xml");

    /**
     * 获得连接池
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
