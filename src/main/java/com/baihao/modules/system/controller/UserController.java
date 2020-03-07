package com.baihao.modules.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baihao.core.controller.BaseController;
import com.baihao.modules.system.entity.User;
import com.baihao.modules.system.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public User get(@RequestParam(required = false) String id) {
        User entity = null;
        if (StrUtil.isNotBlank(id)) {
            entity = userService.get(id);
        }
        if (entity == null) {
            entity = new User();
        }
        return entity;
    }


    @GetMapping("data")
    public PageInfo data(User user, HttpServletRequest request, HttpServletResponse response)
    {
        List<User> userList=new ArrayList<User>();
        PageInfo pageInfo=userService.findPage(user,request,response);
        return pageInfo;
    }

}
