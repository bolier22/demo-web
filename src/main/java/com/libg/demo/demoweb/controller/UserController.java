package com.libg.demo.demoweb.controller;

import com.libg.demo.demoweb.dao.UserDao;
import com.libg.demo.demoweb.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/hello")
    public String helloWorld(){
        return "hello world";
    }

    @RequestMapping("/user/save")
    public UserEntity save(UserEntity userEntity){
        boolean rs = userDao.save(userEntity);
        if(rs)
            System.out.println("-----success");

        return userEntity;
    }

    @RequestMapping("/user/get")
    public UserEntity get(Integer id){
        return userDao.getById(id);
    }


    //flux 如果返回的是0-1 使用 Mono（一个元素）   如果返回的是0-n 使用 Flux（多个元素）
    //@RequestMapping("/user/flux/get")
    //public Mono<UserEntity> getFlux(Integer id){
    //    return Mono.just(userDao.getById(id));
    //}

}
