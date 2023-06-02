package com.xwz.seckill.mapper;

import com.xwz.seckill.pojo.SeckillGoods;
import com.xwz.seckill.pojo.SeckillOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillOrderMapper {

    SeckillOrder querySeckillOrderByGoodsIdAndUserId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);

    int insertSeckillOrder(SeckillOrder seckillOrder);
}
