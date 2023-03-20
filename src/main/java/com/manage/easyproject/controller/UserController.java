package com.manage.easyproject.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.easyproject.pojo.User;
import com.manage.easyproject.service.UserService;
import com.manage.easyproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    //分页获取所有的用户数据
    @GetMapping("users")
    public PageInfo<User> list(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "size", defaultValue = "10") int size,
                                       @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                 @RequestParam(value = "status", defaultValue = "") String status) {
        PageHelper.startPage(start, size, "id desc");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(keyword)) {
            paramMap.put("keyword", keyword);
        }
        if (!StringUtils.isEmpty(status)) {
            paramMap.put("status", status);
        }
        List<User> list = userService.list(paramMap);
        PageInfo<User> page = new PageInfo<User>(list, 5);
        return page;
    }

    //用户注册申请
    @PostMapping("registerUser")
    public Object registerUser(@RequestBody User user) {
        return userService.add(user);
    }

    //根据ID获取单个用户数据
    @GetMapping("users/{id}")
    public User get(@PathVariable("id") int id) {
        return userService.get(id);
    }

    //新增用户数据
    @PostMapping("users")
    public Object add(@RequestBody User user) {
        return userService.add(user);
    }

    //修改用户数据
    @PutMapping("users")
    public Object update(@RequestBody User user) {
        return userService.update(user);
    }

    //根据ID删除用户数据
    @DeleteMapping("users/{id}")
    public Object delete(@PathVariable("id") int id) {
        return userService.delete(id);
    }

    //后台登录
    @PostMapping("loginUser")
    public Object loginUser(@RequestBody User user, HttpSession session) {
        User loginUser = userService.loginUser(user.getAccount(), user.getPassword());
        if (null == loginUser) {
            return Result.fail("账号或密码错误");
        } else {
            if (loginUser.getStatus() == 0) {
                return Result.fail("该账号还未审核");
            } else if (loginUser.getStatus() == 2) {
                return Result.fail("该账号未通过审核");
            } else {
                session.setAttribute("user", loginUser);
                return Result.success();
            }
        }
    }

    //后台注销
    @GetMapping("logoutUser")
    public Object logoutUser(HttpSession session) {
        session.removeAttribute("user");
        return Result.success();
    }

    //获取当前用户信息
    @GetMapping("currentUser")
    public Object get(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return Result.fail("未登录");
        } else {
            User currentUser = userService.get(user.getId());
            return Result.success(currentUser);
        }
    }

    //修改用户个人信息
    @PutMapping("userInfos")
    public Object userInfos(@RequestBody User user) {
        return userService.updateInfo(user);
    }

    //修改密码
    @GetMapping("updateUserPassword")
    public Object updatePassword(String oldPassword, String newPassword, int id){
        return userService.updateUserPassword(oldPassword, newPassword, id);
    }

}
