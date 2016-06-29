package com.lujiahao.web.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 表单校验Bean
 * 这种类型的bean里面所有的字段都是字符串
 * 用于获得浏览器发送的数据,并对数据的有效性进行校验
 *
 * 1.提供校验validate()
 * 2.记录每一项的校验结果
 * Created by lujiahao
 * Created at 2016/6/24 17:14
 */
public class UserFormBean {
    private String id;
    private String username;
    private String password;
    private String repassword;
    private String gender;
    private String age;// 因为服务器传过来的数据都是string类型的

    public UserFormBean() {}

    public UserFormBean(String id, String username, String password, String repassword, String gender, String age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.repassword = repassword;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    // 记录错误信息 key:对应字段  value:提示信息
    private Map<String,String> errorMsg = new HashMap<>();
    /**
     * 校验方法
     * @return
     */
    public boolean validate() {
        boolean temp = true;
        // 用户名不能为空
        if (username == null || "".equals(username)) {
            errorMsg.put("usernameMsg","用户名不能为空");
            temp = false;
        }
        if (password == null || "".equals(password)) {
            errorMsg.put("passwordMsg","密码不能为空");
            temp = false;
        } else if (! password.equals(repassword)){
            errorMsg.put("repasswordMsg","确认密码和密码不一致");
            temp = false;
        }
        return temp;
    }

    public Map<String, String> getErrorMsg() {
        return errorMsg;
    }
}
