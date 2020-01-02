package com.xxl.springbootquick.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ConfigurationProperties  prefix 对应配置文件中哪个对象下的属性
 * Component 将类 注册到容器中
 */

@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {
//    @Email 开启校验
    private String firstName;
    private Integer age;
    private Date birthday;

    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public List<Object> getList() {
        return list;
    }

    public Dog getDog() {
        return dog;
    }
}
