package com.xwz.seckill.service;

import com.xwz.seckill.pojo.User;
import com.xwz.seckill.vo.LoginVo;
import com.xwz.seckill.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 登录功能
     * @param loginVo 登录参数：mobile+password
     * @param response 用于设置cookie
     * @param request 用于设置cookie
     * @return 登录状态
     */
    RespBean doLogin(LoginVo loginVo, HttpServletResponse response, HttpServletRequest request);

    User getUserByRedis(String ticket, HttpServletRequest request, HttpServletResponse response);
}
