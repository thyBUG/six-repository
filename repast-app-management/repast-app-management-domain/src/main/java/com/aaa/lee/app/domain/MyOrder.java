package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "oms_order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ??id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * ????
     */
    @Column(name = "order_sn")
    private String orderSn;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_pic")
    private String productPic;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_brand")
    private String productBrand;

    @Column(name = "product_sn")
    private String productSn;

    /**
     * ????
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * ????
     */
    @Column(name = "product_quantity")
    private Integer productQuantity;

    /**
     * ??sku??
     */
    @Column(name = "product_sku_id")
    private Long productSkuId;

    /**
     * ??sku??
     */
    @Column(name = "product_sku_code")
    private String productSkuCode;

    /**
     * ????id
     */
    @Column(name = "product_category_id")
    private Long productCategoryId;

    /**
     * ???????
     */
    private String sp1;

    private String sp2;

    private String sp3;

    /**
     * ??????
     */
    @Column(name = "promotion_name")
    private String promotionName;

    /**
     * ????????
     */
    @Column(name = "promotion_amount")
    private BigDecimal promotionAmount;

    /**
     * ?????????
     */
    @Column(name = "coupon_amount")
    private BigDecimal couponAmount;

    /**
     * ????????
     */
    @Column(name = "integration_amount")
    private BigDecimal integrationAmount;

    /**
     * ?????????????
     */
    @Column(name = "real_amount")
    private BigDecimal realAmount;

    @Column(name = "gift_integration")
    private Integer giftIntegration;

    @Column(name = "gift_growth")
    private Integer giftGrowth;

    /**
     * ??????:[{"key":"??","value":"??"},{"key":"??","value":"4G"}]
     */
    @Column(name = "product_attr")
    private String productAttr;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }


}