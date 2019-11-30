package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sms_coupon_product_relation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CouponProductRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue注解存在的意义主要就是为一个实体生成一个唯一标识的主键、@GeneratedValue提供了主键的生成策略。
    /**
     * strategy属性：提供四种值:
     *
     * -AUTO主键由程序控制, 是默认选项 ,不设置就是这个
     * -IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
     * -SEQUENCE 通过数据库的序列产生主键, MYSQL  不支持
     * -Table 提供特定的数据库产生主键, 该方式更有利于数据库的移植
       *
     */
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "product_id")
    private Long productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品编码
     */
    @Column(name = "product_sn")
    private String productSn;


}