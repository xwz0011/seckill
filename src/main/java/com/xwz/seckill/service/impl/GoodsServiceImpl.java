package com.xwz.seckill.service.impl;

import com.xwz.seckill.mapper.GoodsMapper;
import com.xwz.seckill.mapper.SeckillGoodsMapper;
import com.xwz.seckill.pojo.SeckillGoods;
import com.xwz.seckill.service.GoodsService;
import com.xwz.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper mapper;

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;
    @Override
    public List<GoodsVO> queryAllGoodsAndSeckillGoods() {
        List<GoodsVO> goodsVOS = mapper.queryAllGoodsAndSeckillGoods();
        System.out.println(goodsVOS);
        return goodsVOS;
    }

    @Override
    public GoodsVO queryGoodsById(Long id) {
        GoodsVO goodsVO = mapper.queryByIdGoodsVo(id);
        System.out.println("goodsVO = " + goodsVO);
        return goodsVO;
    }

    @Override
    public SeckillGoods querySeckillGoodsByGoodsId(Long goodsId) {
        return seckillGoodsMapper.querySeckillGoodsByGoodsId(goodsId);
    }
}
