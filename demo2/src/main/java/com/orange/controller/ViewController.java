package com.orange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/10/5.
 */
@Controller
public class ViewController {
    @RequestMapping("/login.do")
    public String login() throws Exception{
        return "login";
    }
    @RequestMapping("/register.do")
    public String register() throws Exception{
        return "register";
    }
}
