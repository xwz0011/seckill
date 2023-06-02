package com.xwz.seckill.service.impl;

import com.xwz.seckill.mapper.GoodsMapper;
import com.xwz.seckill.mapper.OrderMapper;
import com.xwz.seckill.mapper.SeckillGoodsMapper;
import com.xwz.seckill.mapper.SeckillOrderMapper;
import com.xwz.seckill.pojo.Order;
import com.xwz.seckill.pojo.SeckillOrder;
import com.xwz.seckill.pojo.User;
import com.xwz.seckill.service.SeckillService;
import com.xwz.seckill.vo.GoodsVO;
import com.xwz.seckill.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public SeckillOrder querySeckillOrderByGoodsIdAndUserId(Long userid, Long goodsId) {
        SeckillOrder seckillOrder = seckillOrderMapper.querySeckillOrderByGoodsIdAndUserId(userid, goodsId);
        return seckillOrder;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public OrderVo doSeckill(User user, Long goodsId) {
        // 查询秒杀商品
        GoodsVO goodsVO = goodsMapper.queryByIdGoodsVo(goodsId);
        System.out.println("goodsVO = " + goodsVO);

        // 秒杀商品库存-1
        seckillGoodsMapper.updateStockCount(goodsId);
        // 生成订单
        Order order = new Order();
        order.setGoodsId(goodsId);
        order.setUserId(user.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goodsVO.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(goodsVO.getSeckillGoods().getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        int i = orderMapper.insertOrder(order);
        System.out.println("i = " + i);
        // 生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(order.getGoodsId());
        seckillOrderMapper.insertSeckillOrder(seckillOrder);
        // 生成返回数据
        OrderVo orderVo = new OrderVo();
        orderVo.setDeliveryAddrId(order.getDeliveryAddrId());
        orderVo.setDate(order.getCreateDate());
        orderVo.setUser(user.getNickname());
        orderVo.setImg(goodsVO.getGoodsImg());
        orderVo.setPrice(order.getGoodsPrice());
        orderVo.setGoodsName(order.getGoodsName());
        orderVo.setStatus(order.getStatus());
        return orderVo;
    }
}
