package com.xwz.seckill.controller;

import com.xwz.seckill.pojo.User;
import com.xwz.seckill.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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
        return "goodsList";
    }
}
