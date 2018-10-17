package com.basic.learn08.jpa;

import com.basic.learn08.entity.LoggerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerJPA
        extends JpaRepository<LoggerInfoEntity,Long> {

}
