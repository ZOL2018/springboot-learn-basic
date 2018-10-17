package com.basic.learn13.jpa;

import com.basic.learn13.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface UserJPA extends
        JpaRepository<UserEntity,Long>,
        JpaSpecificationExecutor<UserEntity>,
        Serializable {
    @Query(value = "select * from user where age > ?1",nativeQuery = true)
    List<UserEntity> nativeQuery(int age);

    @Modifying
    @Transactional
    @Query(value = "delete from user where name = ?1 and pwd = ?2",nativeQuery = true)
    void deleteQuery(String name, String pwd);
}
