package com.xwz.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {


    /**
     * 测试类，测试项目搭建是否完成
     * @param model 添加姓名
     * @return 返回hello界面
     */
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","XWZ");
        return "/hello.html";
    }
}
