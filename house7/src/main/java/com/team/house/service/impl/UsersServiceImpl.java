package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.utills.MD5Utils;
import com.team.house.utills.UsersPageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:0:05
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public List<Users> selAllUsers() {
        return usersMapper.selectByExample(new UsersExample());
    }

    public PageInfo<Users> selectUsersLike(UsersPageUtils usersPageUtils) {
        /**/
        PageHelper.startPage(usersPageUtils.getPage(),usersPageUtils.getRows());

        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        if (usersPageUtils.getName()!=null)
            criteria.andNameLike("%"+usersPageUtils.getName()+"%");
        if (usersPageUtils.getTelephone()!=null)
            criteria.andNameLike("%"+usersPageUtils.getTelephone()+"%");
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        System.out.println("usersceshi:"+usersList);
        return new PageInfo<Users>(usersList);
    }


    public int addUsers(Users users) {
        //使用md5工具类对密码加密码
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        /*代表  默认注册用户 而不是商家*/
        users.setIsadmin(0);

        return usersMapper.insertSelective(users);
    }

    public List<Users> likeSelUsers(Users users) {
        return usersMapper.selectByExample(new UsersExample());
    }

    public List<Users> selUsersByName(String name) {
        /*条件对象*/
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        /*添加条件*/
        criteria.andNameEqualTo(name);
        return usersMapper.selectByExample(usersExample);
    }

    public List<Users> checkNamePassword(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users;
    }
}
