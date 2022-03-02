package controller;

import annotation.Autowired;
import annotation.Controller;
import annotation.RequestMapping;
import bean.Data;
import bean.Param;
import bean.View;
import constant.RequestMethod;
import pojo.User;
import service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 996Worker
 * @description
 * @create 2022-03-02 23:30
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public View getUserList() {
        List<User> userList = userService.getAllUser();
        return new View("index.jsp").addModel("userList", userList);
    }

    /**
     * 用户详情
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Data getUserInfo(Param param) {
        String id = (String) param.getParamMap().get("id");
        User user = userService.getUserById(Integer.parseInt(id));

        return new Data(user);
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.GET)
    public Data editUser(Param param) {
        String id = (String) param.getParamMap().get("id");
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("age", 911);
        userService.updateUser(Integer.parseInt(id), fieldMap);

        return new Data("Success.");
    }

}
