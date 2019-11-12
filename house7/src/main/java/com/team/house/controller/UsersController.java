package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.utills.UsersPageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:18:45
 */
@Controller
@RequestMapping("admin")
public class UsersController {
    @Autowired
    private UsersService usersService;
    /*查询所有 包括分页 模糊*/
    @RequestMapping("getAllUsers")
    @ResponseBody
    public Map<String,Object> getAllUsers(UsersPageUtils usersPageUtils){
        System.out.println("查询条件是："+usersPageUtils);
        PageInfo<Users> pageInfo = usersService.selectUsersLike(usersPageUtils);
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("rows",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        System.out.println(pageInfo.getList());
        return map;

    }
    @RequestMapping("searchUsers")
    @ResponseBody
    public List<Users> searchUsers(Users users){
        List<Users> list = usersService.likeSelUsers(users);
        return list;
    }
}
