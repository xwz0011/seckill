package com.xwz.seckill.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SeckillGoods implements Serializable {
    private static final long serializableUID = 2L;
    private Long id;
    private Long goodsId;
    private BigDecimal seckillPrice;
    private Long stockCount;
    private Date startDate;
    private Date endDate;
}
