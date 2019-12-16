package com.badminton.bean;

import javax.persistence.*;

/*
    场地实体类
*/
@Table(name = "site")
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sname;//场地名称
    private String opening_time;//开放时间
    private double price;//场地价格
    private boolean enabled;//场地状态 0表示占用，1表示空闲
    private String user;//使用者

    public Site() {

    }

    public Site(String sname, String opening_time, double price) {
        this.sname = sname;
        this.opening_time = opening_time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
