package com.baihao.modules.system.service;

import cn.hutool.core.util.StrUtil;
import com.baihao.modules.system.entity.User;
import com.baihao.modules.system.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findList(User user)
    {
        return userMapper.findList(user);
    }

    public User get(String id)
    {
        return userMapper.get(id);
    }

    public PageInfo<User> findPage(User user,HttpServletRequest request, HttpServletResponse  response){
        String pageNum= request.getParameter("pageNum");
        String pageSize= request.getParameter("pageSize");
        if (StrUtil.isNotBlank(pageNum) && StrUtil.isNotBlank(pageSize))
        {
            PageHelper.startPage(Integer.valueOf(pageNum),Integer.valueOf(pageSize));
        }
        List<User> userList=userMapper.findList(user);
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        return pageInfo;
    }


}
