package com.basic.learn14.jpa;

import com.basic.learn14.entity.GoodsInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface GoodsJPA extends
        JpaRepository<GoodsInfoEntity,Long>,
        QueryDslPredicateExecutor<GoodsInfoEntity>{
}
