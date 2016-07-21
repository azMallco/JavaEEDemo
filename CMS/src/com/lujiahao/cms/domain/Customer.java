package com.lujiahao.cms.domain;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by lujiahao on 2016/7/19.
 */
public class Customer {
    private String id;
    private String name;
    private String pwd;
    private String gender;

    private Date birthday;
    private String cellphone;
    private String email;

    private String preference;
    private String[] preferenceArr;// 表单提交多个爱好

    private String type;
    private String description;

    private String startBirthday;
    private String endBirthday;

    public String getStartBirthday() {
        return startBirthday;
    }

    public void setStartBirthday(String startBirthday) {
        this.startBirthday = startBirthday;
    }

    public String getEndBirthday() {
        return endBirthday;
    }

    public void setEndBirthday(String endBirthday) {
        this.endBirthday = endBirthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getPreferenceArr() {
        return preferenceArr;
    }

    public void setPreferenceArr(String[] preferenceArr) {
        this.preferenceArr = preferenceArr;
    }

    public String getPreference() {
        if (preferenceArr != null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < preferenceArr.length; i++) {
                if (i != 0){
                    builder.append(",");
                }
                builder.append(preferenceArr[i]);
            }
            preference = builder.toString();
        }

        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", preference='" + preference + '\'' +
                ", preferenceArr=" + Arrays.toString(preferenceArr) +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
