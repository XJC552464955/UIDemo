package com.example.activitylife;

import java.io.Serializable;

//序列化：
//1.如果需要把内存中的对象保存到文件或者数据库中时
//2.利用套接字Socket在网络中传递对象
public class People implements Serializable {
    private  String name;
    private int age;
    private String sex;

    public People(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
