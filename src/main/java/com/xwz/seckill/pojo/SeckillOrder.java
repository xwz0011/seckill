package com.xwz.seckill.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeckillOrder implements Serializable {
    private static final long serializableUID = 5L;
    private Long id;
    private Long goodsId;
    private Long userId;
    private Long orderId;
}
