package com.xwz.seckill.service;

import com.xwz.seckill.pojo.Order;
import com.xwz.seckill.pojo.SeckillOrder;
import com.xwz.seckill.pojo.User;
import com.xwz.seckill.vo.OrderVo;

public interface SeckillService {

    SeckillOrder querySeckillOrderByGoodsIdAndUserId(Long userid, Long goodsId);

    OrderVo doSeckill(User user, Long goodsId);
}
