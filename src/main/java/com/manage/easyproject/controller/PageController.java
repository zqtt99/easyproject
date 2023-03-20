package com.manage.easyproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0.0
 * @ClassName PageController
 * @Description TODO
 */
@Controller
public class PageController {

    //--------------管理员--------------
    @GetMapping("admin")
    public String admin() {
        return "redirect:adminIndex";
    }
    @GetMapping("adminIndex")
    public String adminIndex() {
        return "admin/adminIndex";
    }
    @GetMapping("loginPageAdmin")
    public String loginPageAdmin() {
        return "admin/login";
    }
    @GetMapping("listAdminPassword")
    public String listAdminPassword() {
        return "admin/listAdminPassword";
    }
    @GetMapping("welcome")
    public String welcome() {
        return "common/welcome";
    }
    @GetMapping("listAdminAdmin")
    public String listAdminAdmin() {
        return "admin/listAdminAdmin";
    }
    @GetMapping("listAdminUser")
    public String listAdminUser() {
        return "admin/listAdminUser";
    }

    //--------------用户--------------
    @GetMapping("/")
    public String defaultIndex() {
        return "redirect:user";
    }
    @GetMapping("user")
    public String user() {
        return "redirect:userIndex";
    }
    @GetMapping("userIndex")
    public String userIndex() {
        return "user/userIndex";
    }
    @GetMapping("loginPageUser")
    public String loginPageUser() {
        return "user/login";
    }
    @GetMapping("registerPageUser")
    public String registerPageUser() {
        return "user/register";
    }
    @GetMapping("listUserPassword")
    public String listUserPassword() {
        return "user/listUserPassword";
    }
    @GetMapping("listUserInfo")
    public String listUserInfo() {
        return "user/listUserInfo";
    }
}
