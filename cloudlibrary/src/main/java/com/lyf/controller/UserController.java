package com.lyf.controller;

import com.lyf.domain.User;
import com.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest httpServletRequest){
        try {
            User u = userService.login(user);
            if(u != null){
                httpServletRequest.getSession().setAttribute("USER_SESSION", u);
                return "redirect:/admin/main.jsp";
            }
            httpServletRequest.getSession().setAttribute("msg", "用户名或密码错误");
            return "forward:/admin/login.jsp";
        }catch (Exception e){
            httpServletRequest.getSession().setAttribute("msg", "系统错误：" + e.getMessage());
            return "forward:/admin/login.jsp";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            session.invalidate();
            return "forward:/admin/login.jsp";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg", "系统错误!!!");
            return "forward:/admin/login.jsp";
        }
    }
}
