package com.manage.easyproject.service;


import com.manage.easyproject.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> list(Map<String, Object> paramMap);
    Object add(User user);
    Object delete(int id);
    Object update(User user);
    Object updateInfo(User user);
    User get(int id);
    User loginUser(String account, String password);
    Object updateUserPassword(String oldPassword, String newPassword, int id);
}
