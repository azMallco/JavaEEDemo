package com.lujiahao.cms.utils;

import java.util.UUID;

/**
 * String工具类
 * 功能:
 *  1.获取UUID
 * Created by lujiahao on 2016/7/19.
 */
public class LStringUtils {

    /**
     * 获取一个长度为32的随机字符串
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
