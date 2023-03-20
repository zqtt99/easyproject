package com.manage.easyproject.service.impl;

import com.manage.easyproject.mapper.UserMapper;
import com.manage.easyproject.pojo.User;
import com.manage.easyproject.service.UserService;
import com.manage.easyproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list(Map<String, Object> paramMap) {
        return userMapper.list(paramMap);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }

    @Override
    public User loginUser(String phone, String password) {
        return userMapper.loginUser(phone, password);
    }

    @Override
    public Object updateUserPassword(String oldPassword, String newPassword, int id) {
        User user = userMapper.getByIdAndPassword(id, oldPassword);
        if (null == user) {
            return Result.fail("原密码不正确");
        } else {
            userMapper.updateUserPassword(newPassword, id);
            return Result.success("修改密码成功");
        }
    }

    @Override
    public Object add(User user) {
        if (userMapper.getByAccount(user.getAccount()) > 0) {
            return Result.fail("该账号已被注册");
        } else {
            userMapper.add(user);
            return Result.success();
        }
    }

    @Override
    public Object update(User user) {
        userMapper.update(user);
        return Result.success();
    }

    @Override
    public Object updateInfo(User user) {
        userMapper.updateInfo(user);
        return Result.success();
    }

    @Override
    public Object delete(int id) {
        userMapper.delete(id);
        return Result.success();
    }
}
