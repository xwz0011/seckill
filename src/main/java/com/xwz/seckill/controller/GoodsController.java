package com.xwz.seckill.controller;

import com.xwz.seckill.mapper.GoodsMapper;
import com.xwz.seckill.pojo.User;
import com.xwz.seckill.service.GoodsService;
import com.xwz.seckill.service.UserService;
import com.xwz.seckill.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 商品列表
     * jmeter测试：
     * windows：1356.4
     * linux：265.2
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/toList")
    public String toLogin(Model model, User user){
        // 使用UserArgumentResolve提前对请求进行过滤
//        if (StringUtils.isEmpty(ticket)){
//            return "login";
//        }
//        // 从session中获取user信息
//        // User user = (User) session.getAttribute(ticket);
//
//        // 从redis中获取user信息
//        User user = userService.getUserByRedis(ticket, request, response);
//        if (null == user){
//            return "login";
//        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList",goodsService.queryAllGoodsAndSeckillGoods());
        return "goodsList";
    }

    @GetMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable("goodsId")Long goodsId){
        model.addAttribute("user", user);
        GoodsVO goodsVO = goodsService.queryGoodsById(goodsId);
        Date startDate = goodsVO.getSeckillGoods().getStartDate();
        Date endDate = goodsVO.getSeckillGoods().getEndDate();
        int secKillStatus = -1;
        Date nowDate = new Date();
        int remainSeconds = -1;
        if (nowDate.before(startDate)) {
            secKillStatus = 0;
            remainSeconds = (int)((startDate.getTime()-nowDate.getTime())/1000);
        }else if (nowDate.after(endDate)){
            secKillStatus = 2;
        }else {
            remainSeconds=0;
            secKillStatus = 1;
        }
        System.out.println("secKillStatus = " + secKillStatus);
        model.addAttribute("goods", goodsVO);
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goodsDetail";
    }
}
