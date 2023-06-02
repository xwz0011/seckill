package com.xwz.seckill.mapper;

import com.xwz.seckill.pojo.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    int insertOrder(Order order);
}
