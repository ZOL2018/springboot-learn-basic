package com.basic.learn17.service;

import com.basic.learn17.entity.UserEntity;
import com.basic.learn17.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService
{
    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJPA.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
        }
        return user;
    }
}
