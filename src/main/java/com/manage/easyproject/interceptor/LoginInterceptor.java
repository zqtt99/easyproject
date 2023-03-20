package com.manage.easyproject.interceptor;

import com.manage.easyproject.pojo.Admin;
import com.manage.easyproject.pojo.User;
import com.manage.easyproject.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        if (uri.startsWith("/api")) {
            return true;
        }
        //当url是/multishop/admin开头时，说明是后台管理系统登录，则需要判断当前用户是否登录
        if (uri.startsWith("/adminIndex")) {
            Admin admin = (Admin) session.getAttribute("admin");
            if (null == admin) {
                //用户为空则跳转至loginPageAdmin即后台登录页面
                response.sendRedirect("loginPageAdmin");
                return false;
            }
        }
        //当url是/multishop/user开头时，说明是用户登录，则需要判断当前用户是否登录
        if (uri.startsWith("/userIndex")) {
            User user = (User) session.getAttribute("user");
            if (null == user) {
                //用户为空则跳转至loginPageAdmin即后台登录页面
                response.sendRedirect("loginPageUser");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
