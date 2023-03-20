package com.manage.easyproject.mapper;

import com.manage.easyproject.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @ClassName UserMapper
 * @Description TODO
 */
@Mapper
public interface UserMapper {
    List<User> list(Map<String, Object> paramMap);
    void add(User user);
    void delete(int id);
    void update(User user);
    void updateInfo(User user);
    int getByAccount(String account);
    User get(int id);
    User loginUser(String phone, String password);
    void updateUserPassword(String password, int id);
    User getByIdAndPassword(int id, String password);
}
