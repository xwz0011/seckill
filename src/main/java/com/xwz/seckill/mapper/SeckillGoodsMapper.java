package com.xwz.seckill.mapper;

import com.xwz.seckill.pojo.SeckillGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeckillGoodsMapper {
    SeckillGoods querySeckillGoodsByGoodsId(Long id);

    int updateStockCount(Long goodsId);
}
