package com.basic.learn14.controller;

import com.basic.learn14.entity.GoodsInfoEntity;
import com.basic.learn14.entity.QGoodsInfoEntity;
import com.basic.learn14.inquirer.Inquirer;
import com.basic.learn14.jpa.GoodsJPA;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class GoodsController {
    @Autowired
    private GoodsJPA goodsJPA;

    //EntityManager 注入
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 使用QueryDSL
     * @return
     */
    @RequestMapping(value = "/good")
    public List<GoodsInfoEntity> good(){
        QGoodsInfoEntity _goods_info_entity = QGoodsInfoEntity.goodsInfoEntity;
        // JAPQuery 查询对象
        JPAQuery<GoodsInfoEntity> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery
                .select(_goods_info_entity)
                .from(_goods_info_entity)
                .where(_goods_info_entity.type.id.eq(Long.valueOf("1")))
                .fetch();
    }

    /**
     * 使用QueryDSL 结合 jpa
     * @return
     */
    @RequestMapping(value = "/goods")
    public List<GoodsInfoEntity> goods(){
        QGoodsInfoEntity _goods_info_entity = QGoodsInfoEntity.goodsInfoEntity;
        /*BooleanExpression expression = _goods_info_entity.type
                .id.eq(Long.valueOf("1"));
        Iterator<GoodsInfoEntity> iterator = goodsJPA.findAll(expression).iterator();
        List<GoodsInfoEntity> goodsInfoEntityList = new ArrayList<>();
        while (iterator.hasNext()){
            goodsInfoEntityList.add(iterator.next());
        }
        return goodsInfoEntityList;*/
        Inquirer inquirer = new Inquirer();
        inquirer.putExpression(_goods_info_entity.id.eq(Long.valueOf("1")));
        return inquirer.iteratorToList(goodsJPA.findAll(inquirer.buidleQuery()));
    }
}
