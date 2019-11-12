package com.team.house.controller;

import com.team.house.entity.EHouse;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/27
 * @Time:19:18
 */
@Controller
@RequestMapping("admin")
public class HouseController {
    @Autowired
    private HouseService houseService;
    /*查询未审核*/
    @RequestMapping("selEHouseByState")
    @ResponseBody
    public List<EHouse> selEHouseByState(){
        List<EHouse> eHouseList = houseService.selEHouseByState(0);
        System.out.println(eHouseList);
        return eHouseList;
    }

    @RequestMapping("selEHouseByStatePassed")
    @ResponseBody
    public List<EHouse> selEHouseByStatePassed(){
        List<EHouse> eHouseList = houseService.selEHouseByState(1);
        System.out.println(eHouseList);
        return eHouseList;
    }
    /*查询所有*/
    @RequestMapping("ah")
    @ResponseBody
    public List<House> ah(){
        List<House> ah = houseService.ah();
        System.out.println(ah);
        return ah;
    }
    /*审核*/
    @RequestMapping("goPass")
    @ResponseBody
    public String goPass(String id){
        int i = houseService.goPass(id,1);
        System.out.println(id);
        System.out.println(i);
        return "{\"result\":"+i+"}";
    }
    /*取消审核*/
    @RequestMapping("gochangPassed")
    @ResponseBody
    public String gochangPassed(String id){
        int i = houseService.goPass(id,0);
        System.out.println(id);
        System.out.println(i);
        return "{\"result\":"+i+"}";
    }
}
