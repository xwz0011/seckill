package com.xwz.seckill.controller;

import com.xwz.seckill.service.UserService;
import com.xwz.seckill.vo.LoginVo;
import com.xwz.seckill.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService service;

    /**
     * 功能描述：跳转登录页
     * @return 登陆页面
     */
    @GetMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Validated LoginVo loginVo, HttpServletRequest request, HttpServletResponse response){
        RespBean respBean = service.doLogin(loginVo,response,request);
        return respBean;
    }

}
