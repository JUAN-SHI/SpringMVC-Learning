package com.www.spring;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by shijuan on 2018/1/11.
 */
@XmlRootElement(name="user")
public class User {
    private String name;
    private int id;

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
   @XmlElement
    public void setId(int id) {
        this.id = id;
    }
}
