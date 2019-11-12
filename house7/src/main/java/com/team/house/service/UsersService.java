package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.utills.UsersPageUtils;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:0:04
 */
public interface UsersService {
    /*显示所有用户*/
    List<Users> selAllUsers();
    /*分页  /*模糊查询*/
    PageInfo<Users> selectUsersLike(UsersPageUtils usersPageUtils);


    /*注册*/
    int addUsers(Users users);


    List<Users> likeSelUsers(Users users);



    /*查询用户名*/
    List<Users> selUsersByName(String name);

    /*check name  password*/
    List<Users> checkNamePassword(String name,String password);

}
