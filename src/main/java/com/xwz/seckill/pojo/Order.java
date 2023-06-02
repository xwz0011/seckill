package com.xwz.seckill.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order implements Serializable {
    private static final long serializableUID = 3L;
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long deliveryAddrId;
    private String goodsName;
    private int goodsCount;
    private BigDecimal goodsPrice;
    private int orderChannel;
    private int status;
    private Date createDate;
    private Date payDate;
}
