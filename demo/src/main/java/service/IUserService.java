package service;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> getAllUser();

    User getUserById(Integer id);

    boolean updateUser(int id, Map<String, Object> fieldMap);

}
