package com.xwz.seckill.controller;

import com.xwz.seckill.pojo.Order;
import com.xwz.seckill.pojo.SeckillGoods;
import com.xwz.seckill.pojo.SeckillOrder;
import com.xwz.seckill.pojo.User;
import com.xwz.seckill.service.GoodsService;
import com.xwz.seckill.service.SeckillService;
import com.xwz.seckill.vo.OrderVo;
import com.xwz.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SeckillService seckillService;

    @PostMapping("/doSeckill")
    public String doSeckill(Model model, Long goodsId, User user){
        // 判断用户是否登录
        if (null == user) {
            return "login";
        }
        // 判断商品库存
        SeckillGoods seckillGoods = goodsService.querySeckillGoodsByGoodsId(goodsId);
        if (seckillGoods.getStockCount() < 1) {
            model.addAttribute("errorMsg", RespBeanEnum.SECKILL_STOCK_ERROR);
            return "seckillFail";
        }
        // 判断是否重复购买
        SeckillOrder seckillOrder = seckillService.querySeckillOrderByGoodsIdAndUserId(user.getId(), goodsId);
        if (null != seckillOrder) {
            model.addAttribute("errorMsg", RespBeanEnum.SECKILL_DOUBLE_BUY);
            return "seckillFail";
        }
        OrderVo orderVo = seckillService.doSeckill(user, goodsId);
        model.addAttribute("order", orderVo);
        return "OrderDetail";
    }
}
