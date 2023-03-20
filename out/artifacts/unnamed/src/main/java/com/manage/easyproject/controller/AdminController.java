package com.manage.easyproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.easyproject.pojo.Admin;
import com.manage.easyproject.service.AdminService;
import com.manage.easyproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员后台管理
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    //后台登录
    @PostMapping("loginAdmin")
    public Object loginAdmin(@RequestBody Admin admin, HttpSession session) {
        Admin loginAdmin = adminService.loginAdmin(admin.getName(), admin.getPassword());
        if (null == loginAdmin) {
            return Result.fail();
        } else {
            session.setAttribute("admin", loginAdmin);
            return Result.success();
        }
    }

    //后台注销
    @GetMapping("logoutAdmin")
    public Object logoutAdmin(HttpSession session) {
        session.removeAttribute("admin");
        return Result.success();
    }

    //获取当前管理员信息
    @GetMapping("currentAdmin")
    public Object get(HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        if (null == admin) {
            return Result.fail("未登录");
        } else {
            Admin currentAdmin = adminService.get(admin.getId());
            return Result.success(currentAdmin);
        }
    }

    //修改密码
    @GetMapping("updateAdminPassword")
    public Object updatePassword(String oldPassword, String newPassword, int id){
        return adminService.updateAdminPassword(oldPassword, newPassword, id);
    }

    //分页获取所有的系统用户数据
    @GetMapping("admins")
    public PageInfo<Admin> list(@RequestParam(value = "start", defaultValue = "1") int start,
                                @RequestParam(value = "size", defaultValue = "10") int size,
                                @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        PageHelper.startPage(start, size, "id desc");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(keyword)) {
            paramMap.put("keyword", keyword);
        }
        List<Admin> list = adminService.list(paramMap);
        PageInfo<Admin> page = new PageInfo<Admin>(list, 5);
        return page;
    }

    //根据ID获取单个系统用户数据
    @GetMapping("admins/{id}")
    public Admin get(@PathVariable("id") int id) {
        return adminService.get(id);
    }

    //新增系统用户数据
    @PostMapping("admins")
    public Object add(@RequestBody Admin acategory) {
        return adminService.add(acategory);
    }

    //修改系统用户数据
    @PutMapping("admins")
    public Object update(@RequestBody Admin acategory) {
        return adminService.update(acategory);
    }

    //根据ID删除系统用户数据
    @DeleteMapping("admins/{id}")
    public Object delete(@PathVariable("id") int id) {
        return adminService.delete(id);
    }

}
