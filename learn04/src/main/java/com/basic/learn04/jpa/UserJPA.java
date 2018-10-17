package com.basic.learn04.jpa;

import com.basic.learn04.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {
}
