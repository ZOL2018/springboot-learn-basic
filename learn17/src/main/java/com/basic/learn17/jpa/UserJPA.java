package com.basic.learn17.jpa;

import com.basic.learn17.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<UserEntity,Long>
{
    //使用SpringDataJPA方法定义查询
    public UserEntity findByUsername(String username);
}
