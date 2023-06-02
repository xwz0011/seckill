package com.xwz.seckill.service;

import com.xwz.seckill.pojo.SeckillGoods;
import com.xwz.seckill.vo.GoodsVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
    List<GoodsVO> queryAllGoodsAndSeckillGoods();

    GoodsVO queryGoodsById(Long id);

    SeckillGoods querySeckillGoodsByGoodsId(Long goodsId);
}
