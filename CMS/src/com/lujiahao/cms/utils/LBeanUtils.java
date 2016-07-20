package com.lujiahao.cms.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

/**
 * BeanUtils封装工具类
 * Created by lujiahao on 2016/7/19.
 */
public class LBeanUtils {

    /**
     * 表单数据的封装
     * 用法: Customer customer = LBeanUtils.populate(Customer.class,request.getParameterMap());
     * @param beanClass 要封装的JavaBean
     * @param properties 数据
     * @param <T> 泛型
     * @return
     */
    public static <T> T populate(Class<T> beanClass , Map<String,String[]> properties){
        try {
            // 1.反射实例化
            T bean = beanClass.newInstance();
            // 2.时间类型转换器
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy-MM-dd HH:mm:ss"});
            ConvertUtils.register(dateConverter,java.util.Date.class);
            // 3.将数据封装到bean中
            BeanUtils.populate(bean,properties);
            return bean;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
