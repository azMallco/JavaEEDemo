package com.lujiahao.dao;

import com.lujiahao.domain.User;
import com.lujiahao.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * 对数据进行增删改查
 * 提供5个方法(添加/更新/删除/查询所有/通过唯一标示查询)
 * Created by lujiahao
 * Created at 2016/6/24 17:16
 */
public class UserDao {
    /**
     * 添加方法
     *
     * @param user 用户bean
     */
    public void save(User user) {

    }

    /**
     * 更新(编辑)
     *
     * @param user
     */
    public void update(User user) {

    }

    /**
     * 删除
     *
     * @param id 用户id
     */
    public void delete(String id) {

    }

    /**
     * 查询所有用户信息
     * 思想:一般dao层如果出现异常,都是自己进行try catch,但是需要通知调用dao方法的地方,通常是throw RuntimeException/自定义异常
     * @return 所有用户信息集合
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try {
            // 1.获得document
            Document document = XmlUtils.getDocument();
            // 2.获得根元素
            Element rootElement = document.getRootElement();
            // 3.获得所有的user元素
            List<Element> allElement = rootElement.elements("user");
            // 4.遍历
            for (Element element : allElement) {
                String id = element.attributeValue("id");
                String username = element.element("username").getText();
                String password = element.elementText("password");
                String gender = element.elementText("gender");
                String age = element.elementText("age");

                // 封装javabean
                User user = new User(id,username,password,gender,age);
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 查询的用户信息
     */
    public User findById(String id) {
        return null;
    }
}
