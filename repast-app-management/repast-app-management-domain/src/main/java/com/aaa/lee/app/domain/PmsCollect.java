package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "pms_collect")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PmsCollect implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "open_id")
    private String openId;

}