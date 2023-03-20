package com.manage.easyproject.service;

import com.manage.easyproject.pojo.Admin;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @ClassName AdminService
 * @Description TODO
 */
public interface AdminService {
    Admin loginAdmin(String name, String password);
    Admin get(int id);
    Object updateAdminPassword(String oldPassword, String newPassword, int id);
    List<Admin> list(Map<String, Object> paramMap);
    Object add(Admin admin);
    Object update(Admin admin);
    Object delete(int id);
}
