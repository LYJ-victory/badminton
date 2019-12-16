package com.badminton.bean;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String academic_work_num;//学工号
    private String username;//用户名
    private int sex;//性别0:男，1：女
    private String telephone;//联系电话
    private String password;//密码

    public User() {

    }

    public User(String academic_work_num, String username, Integer sex, String telephone, String password) {
        this.academic_work_num = academic_work_num;
        this.username = username;
        this.sex = sex;
        this.telephone = telephone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademic_work_num() {
        return academic_work_num;
    }

    public void setAcademic_work_num(String academic_work_num) {
        this.academic_work_num = academic_work_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
