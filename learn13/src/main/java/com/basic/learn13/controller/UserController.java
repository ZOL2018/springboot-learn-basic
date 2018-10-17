package com.basic.learn13.controller;

import com.basic.learn13.entity.UserEntity;
import com.basic.learn13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }
    @RequestMapping(value = "/ages")
    public List<UserEntity> ages(){
        return userJPA.nativeQuery(50);
    }

    @RequestMapping(value = "/del")
    public String del(){
        userJPA.deleteQuery("test1","123");
        return "success";
    }


    // ... 自定义BaseRepository -- 13



}
