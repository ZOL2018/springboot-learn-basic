package com.basic.learn14.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "goods_info")
public class GoodsInfoEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "order")
    private int order;

    @OneToOne
    @JoinColumn(name = "type")
    private GoodsTypeEntity type;
}
