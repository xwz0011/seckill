package com.xwz.seckill.service.impl;

import com.xwz.seckill.config.RedisConfig;
import com.xwz.seckill.mapper.UserMapper;
import com.xwz.seckill.pojo.User;
import com.xwz.seckill.service.UserService;
import com.xwz.seckill.utils.CookieUtil;
import com.xwz.seckill.utils.MD5Util;
import com.xwz.seckill.utils.UUIDUtil;
import com.xwz.seckill.vo.LoginVo;
import com.xwz.seckill.vo.RespBean;
import com.xwz.seckill.vo.RespBeanEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletResponse response, HttpServletRequest request) {
        String id = loginVo.getMobile();
        String password = loginVo.getPassword();
        User user = mapper.queryById(id);
        // 无此用户
        if (user == null) {
            return RespBean.error(RespBeanEnum.ERROR_LOGIN);
        }
        // 密码错误
        if ( !MD5Util.formPassToDBPass(password, user.getSlat()).equals(user.getPassword())){
            return RespBean.error(RespBeanEnum.ERROR_LOGIN);
        }
        String ticket = UUIDUtil.uuid();
        // 将用户信息存储再session中
//        request.getSession().setAttribute(ticket, user);
        // 将用户信息存储在redis中
        redisTemplate.opsForValue().set("user:"+ticket, user);
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByRedis(String ticket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(ticket)){
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        if (null != user) {
            CookieUtil.setCookie(request,response,"userTicket",ticket);
        }
        return user;
    }
}
