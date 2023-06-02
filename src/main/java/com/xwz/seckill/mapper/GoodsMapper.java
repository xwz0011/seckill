package com.xwz.seckill.mapper;

import com.xwz.seckill.vo.GoodsVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    /**
     * 查找所有商品和商品秒杀信息
     * @return List
     */
    List<GoodsVO> queryAllGoodsAndSeckillGoods();

    /**
     * 根据id查找商品详情
     * @return
     */
    GoodsVO queryByIdGoodsVo(Long id);
}
