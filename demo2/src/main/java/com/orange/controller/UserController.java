package com.orange.controller;

import com.orange.model.User;
import com.orange.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 2018/10/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService userService;

    //返回用户主页
    @RequestMapping(value = "/userView.do")
    public String userView() throws Exception{
        return "userPage";
    }
    //返回管理员主页
    @RequestMapping(value = "/administratorView.do")
    public String administratorView() throws Exception{
        return "administrator";
    }
    //跳转至充值页面
    @RequestMapping(value = "rechargeView.do")
    public String rechargeView() throws Exception{
        return "recharge";
    }
    //登录
    @RequestMapping(value = "/login.do")
    public String login(User user, String log, HttpSession session, HttpServletResponse response, Model model) throws Exception{
        User user1 = userService.login(user);
        if(user1==null){
            model.addAttribute("message","登录失败，用户名或密码错误！");
            return "login";
        }else if(user1.getId()==666){
            session.setAttribute("user",user1);
            return "administrator";
        }else {
            session.setAttribute("user",user1);
            if (log != null){
                String name = URLEncoder.encode(user1.getName(),"UTF-8");
                Cookie cookie = new Cookie("name",name);
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
            return "userPage";
        }
    }
    //注册
    @RequestMapping(value = "/register.do")
    public String register(User user, HttpServletRequest request) throws Exception{
        if (!userService.saveUser(user)) {
            request.setAttribute("message", "注册失败");
            return "register";
        } else {
            request.setAttribute("message", "注册成功！");
            return "login";
        }
    }
    //检查注册时用户名是否重复
    @RequestMapping(value = "/checkRegister.do")
    public void checkRegister(User user, HttpServletResponse response) throws Exception{
        if(userService.getUserByName(user) != null){
            response.getWriter().print("123");
        }
    }
    //自动登录
    @RequestMapping(value = "/autoLogin.do")
    public String autoLogin(HttpServletRequest request) throws Exception{
        Cookie[] cookies = request.getCookies();
        String name = "";
        if(cookies==null||cookies.length==0){
            return "login";
        }
        List<User> uList = userService.getAllUser();
        for (Cookie cookie:cookies) {
            if("name".equals(cookie.getName())){
                name = URLDecoder.decode(cookie.getValue(),"UTF-8");
                for (User user:uList) {
                    if(name.equals(user.getName())){
                        return "userPage";
                    }
                }
            }
        }
        return "login";
    }
    //用户充值
    @RequestMapping(value = "/recharge.do")
    public String recharge(Double money, HttpSession session, Model model) throws Exception{
        User user = (User) session.getAttribute("user");
        if(user == null){
            model.addAttribute("message","用户信息已失效，请重新登录！");
            return "login";
        }
        user.setMoney(user.getMoney()+money);
        if(userService.updateUser(user)){
            model.addAttribute("message","充值成功");
            session.setAttribute("user",userService.getUserById(user.getId()));
        }else {
            model.addAttribute("message","充值失败");
        }
        return "userPage";
    }
}
