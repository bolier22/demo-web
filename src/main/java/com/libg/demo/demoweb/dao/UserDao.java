package com.libg.demo.demoweb.dao;

import com.libg.demo.demoweb.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class UserDao {
    //db
    private final ConcurrentMap<Integer, UserEntity> dbMap = new ConcurrentHashMap<>();

    //id 自动生成器
    private final static AtomicInteger idGen = new AtomicInteger();

    //save db
    public boolean save(UserEntity userEntity){
        Integer id = idGen.incrementAndGet();

        userEntity.setId(id);
        return dbMap.put(id,userEntity) == null;
    }

    //query by id
    public UserEntity getById(Integer id){
        return dbMap.get(id);
    }


}
