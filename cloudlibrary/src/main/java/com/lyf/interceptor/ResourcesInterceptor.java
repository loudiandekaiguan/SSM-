package com.lyf.interceptor;

import com.lyf.domain.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourcesInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user_session = (User) request.getSession().getAttribute("USER_SESSION");
        String uri = request.getRequestURI();
        if(user_session != null){
            return true;
        }
        if(uri.contains("login")){
            return true;
        }

        request.setAttribute("msg", "您还没有登录，请先登录！！！");
        request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        return false;
    }
}
