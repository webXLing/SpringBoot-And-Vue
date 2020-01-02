package com.xxl.springbootquick.controller;


import com.xxl.springbootquick.bean.Person1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testComtro {

    @Value("${person.firstName}")
    private String name;

    @Autowired
    private Person1 person1;

    @RequestMapping("/test")
    public Object test(){

        return "holle"+name ;
    }


    @RequestMapping("/person")
    public Object person(){

        return person1 ;
    }
}
