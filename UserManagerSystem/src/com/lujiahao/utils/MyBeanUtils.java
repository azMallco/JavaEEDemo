package com.lujiahao.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * JavaBean工具类
 * Created by lujiahao
 * Created at 2016/6/29 17:05
 */
public class MyBeanUtils {

    /**
     * 创建JavaBean实例,并自动将对应的参数进行封装
     * @param beanClass
     * @param parameterMap
     * @param <T>
     * @return
     */
    public static <T> T populate(Class<T> beanClass, Map<String,String[]> parameterMap){
        try {
            // 1.使用反射创建javabean实例
            T bean = beanClass.newInstance();
            // 2.获得javabean属性(property username-->setUsername()-->执行set方法,数据来自map
            // 2.1获得所有属性--使用内省(java.beans.Introspector):jdk提供工具类,用于操作javabean
            // BeanInfo jdk提供用于对javabean进行描述(封装)对象
            BeanInfo beanInfo = Introspector.getBeanInfo(beanClass, Object.class);
            // 2.2 获得所有的属性描述对象
            PropertyDescriptor[] allPd = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : allPd) {
                // 2.3 获得属性名称
                String propName = pd.getName();
                // 2.4 获得表单中对应的数据
                String[] allValue = parameterMap.get(propName);
                if (allValue == null) {
                    continue;// 当没有值的时候就跳过这个字段
                }
                String propValue = allValue[0];
                // 2.5 如果有值,将执行set方法
                if (propValue != null && !"".equals(propValue)) {
                    Method writeMethod = pd.getWriteMethod();// 相当于set方法    getReadMethod--相当于get方法
                    if (writeMethod != null) {
                        writeMethod.invoke(bean,propValue);
                    }
                }
            }
            return bean;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

