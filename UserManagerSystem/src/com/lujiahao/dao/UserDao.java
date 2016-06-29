package com.lujiahao.dao;

import com.lujiahao.domain.User;
import com.lujiahao.utils.XmlUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

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
        try {
            // 1.获得document
            Document document = XmlUtils.getDocument();
            // 2.获得根元素
            Element rootElement = document.getRootElement();
            // 3.给根元素添加user元素
            Element userElement = rootElement.addElement("user");
            userElement.addAttribute("id",user.getId());
            userElement.addElement("username").setText(user.getUsername());
            userElement.addElement("password").setText(user.getPassword());
            userElement.addElement("gender").setText(user.getGender());
            userElement.addElement("age").setText(user.getAge());
            // 4.回写
            XmlUtils.saveXml(document);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新(编辑)
     *
     * @param user
     */
    public User update(User user) {
        try {
            Document document = XmlUtils.getDocument();
            Element userElement = (Element) document.selectSingleNode("//user[@id='"+user.getId()+"']");
            userElement.element("username").setText(user.getUsername());
            userElement.element("password").setText(user.getPassword());
            userElement.element("gender").setText(user.getGender());
            userElement.element("age").setText(user.getAge());
            XmlUtils.saveXml(document);
            return elementToUser(userElement);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除
     *
     * @param id 用户id
     */
    public User delete(String id) {
        try {
            Document document = XmlUtils.getDocument();
            Element userElement = (Element) document.selectSingleNode("//user[@id='"+id+"']");
            if (userElement == null) {
                return null;
            }
            Element userElementParent = userElement.getParent();
            userElementParent.remove(userElement);
            XmlUtils.saveXml(document);
            return elementToUser(userElement);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
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
                list.add(elementToUser(element));
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
        try {
            Document document = XmlUtils.getDocument();
            Element userElement = (Element) document.selectSingleNode("//user[@id='"+id+"']");
            if (userElement == null) {
                return null;
            }
            return elementToUser(userElement);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 将element封装到javabean中
     * @param userElement
     * @return
     */
    private User elementToUser(Element userElement){
        String id = userElement.attributeValue("id");
        String username = userElement.element("username").getText();
        String password = userElement.elementText("password");
        String gender = userElement.elementText("gender");
        String age = userElement.elementText("age");

        // 封装javabean
        User user = new User(id,username,password,gender,age);
        return user;
    }

    /**
     * 通过用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    public User find(String username, String password) {
        try {
            Document document = XmlUtils.getDocument();
            Element userElement = (Element) document.selectSingleNode("//user[username='"+username+"' and password='"+password+"']");
            if (userElement == null) {
                return null;
            }
            return elementToUser(userElement);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
