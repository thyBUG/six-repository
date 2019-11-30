package com.aaa.lee.app.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MemberCouponInfoVo implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "use_status")
    private int useStatus;

    @Column(name = "use_time")
    private Date useTime;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "coupon_id")
    private Long couponId;

    private int type;

    private String name;

    private int platform;

    private int count;

    private double amount;

    @Column(name = "min_point")
    private double minPoint;

    @Column(name = "start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @Column(name = "end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @Column(name = "use_type")
    private int useType;

    private String note;

    @Column(name = "use_count")
    private int useCount;

    private String code;
}
