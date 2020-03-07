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
        String pageNumStr= request.getParameter("pageNum");
        String pageSizeStr= request.getParameter("pageSize");
        Integer pageNum=StrUtil.isNotBlank(pageNumStr)?Integer.valueOf(pageNumStr):1;
        Integer pageSize=StrUtil.isNotBlank(pageSizeStr)?Integer.valueOf(pageSizeStr):10;

        //默认分页显示10条数据,当传参pageSize=0时，不分页
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList=userMapper.findList(user);
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        return pageInfo;
    }
}
