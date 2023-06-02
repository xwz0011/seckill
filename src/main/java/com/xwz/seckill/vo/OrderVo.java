package com.xwz.seckill.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVo {
    private BigDecimal price;
    private Date date;
    private int status;
    private String user;
    private Long deliveryAddrId;
    private String img;
    private String goodsName;
}
