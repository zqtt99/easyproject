package com.manage.easyproject.mapper;

import com.manage.easyproject.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @ClassName AdminMapper
 * @Description TODO
 */
@Mapper
public interface AdminMapper {
    Admin loginAdmin(String name, String password);
    void updateAdminPassword(String password, int id);
    Admin getByIdAndPassword(int id, String password);
    List<Admin> list(Map paramMap);
    Admin get(int id);
    int getByName(String name);
    void add(Admin admin);
    void update(Admin admin);
    void delete(int id);
}
