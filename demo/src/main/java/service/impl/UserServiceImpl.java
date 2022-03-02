package service.impl;

import annotation.Service;
import helper.DatabaseHelper;
import pojo.User;
import service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * @author 996Worker
 * @description
 * @create 2022-03-02 23:28
 */
@Service
public class UserServiceImpl implements IUserService {
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        return DatabaseHelper.queryEntityList(User.class, sql);
    }

    public User getUserById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return DatabaseHelper.queryEntity(User.class, sql, id);
    }

    public boolean updateUser(int id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(User.class, id, fieldMap);
    }
}