package com.manage.easyproject.service.impl;

import com.manage.easyproject.mapper.AdminMapper;
import com.manage.easyproject.pojo.Admin;
import com.manage.easyproject.service.AdminService;
import com.manage.easyproject.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @ClassName AdminServiceImpl
 * @Description TODO
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin loginAdmin(String name, String password) {
        return adminMapper.loginAdmin(name, password);
    }

    @Override
    public Admin get(int id) {
        return adminMapper.get(id);
    }

    @Override
    public Object updateAdminPassword(String oldPassword, String newPassword, int id) {
        Admin admin = adminMapper.getByIdAndPassword(id, oldPassword);
        if (null == admin) {
            return Result.fail("原密码不正确");
        } else {
            adminMapper.updateAdminPassword(newPassword, id);
            return Result.success("修改密码成功");
        }
    }

    @Override
    public List<Admin> list(Map<String, Object> paramMap) {
        return adminMapper.list(paramMap);
    }

    @Override
    public Object add(Admin admin) {
        if (adminMapper.getByName(admin.getName()) > 0) {
            return Result.fail("该账号已被注册");
        } else {
            adminMapper.add(admin);
            return Result.success();
        }
    }

    @Override
    public Object update(Admin admin) {
        adminMapper.update(admin);
        return Result.success();
    }

    @Override
    public Object delete(int id) {
        adminMapper.delete(id);
        return Result.success();
    }
}
