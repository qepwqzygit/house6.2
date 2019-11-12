package com.team.house.pController;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:0:31
 */
@Controller("UsersController2")
@RequestMapping("page")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("addUsers")
    public String addUsers(Users users){
        System.out.println(users);
        int i = usersService.addUsers(users);
        if (i>0)
            return "login";
        else
            return "regs";
    }
    @RequestMapping("checkName")
    @ResponseBody
    public String addUsers(String name){
        List<Users> users = usersService.selUsersByName(name);
        System.out.println(name);
            return "{\"result\":"+users.size()+"}";
    }
    @RequestMapping("checkNamePassword")
    public String checkNamePassword(String name, String password, HttpSession session){
        List<Users> usersList = usersService.checkNamePassword(name, password);
        System.out.println(name);
        System.out.println(password);
        //return "{\"result\":"+usersList.size()+"}";
        System.out.println(usersList);
        if (usersList.size()==0)
            return "login";
        else
            session.setAttribute("userinfo",usersList.get(0));
            return "redirect:selEHouse";
    }

}
