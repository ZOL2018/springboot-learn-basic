package com.basic.learn08.jpa;

import com.basic.learn08.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {
}
