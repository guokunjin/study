package com.repository.entity;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class Person{
    private Integer id;

    private String name;

    private Integer age;

    private String headImg;

    public Person() {
    }

    public Person(Integer id, String name, Integer age, String headImg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.headImg = headImg;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
