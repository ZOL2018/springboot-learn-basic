package com.basic.learn16.service;

import com.basic.learn16.entity.UserEntity;
import com.basic.learn16.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {
    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<UserEntity> list()
    {
        return userJPA.findAll();
    }
}
