package com.orange.model;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/28.
 */

public class User implements Serializable{
    private Integer id;
    private String name;
    private String pass;
    private String sex;
    private double money;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
        sex = "男";
        money = 0;
    }

    public User(String name, String pass, String sex) {
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        money = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", money=" + money +
                '}';
    }
}
