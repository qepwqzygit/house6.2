package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.utills.PageUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:ZY
 * @date:${date}${time}
 */
@Controller
@RequestMapping(("admin"))
public class districtController {
    @Autowired
    private DistrictService districtService;
    //添加
    @RequestMapping("addDistrit")
    @ResponseBody
    public Map<String,Object> addDistrit(District district){
        int i = districtService.insertDistrict(district);
        System.out.println("i:"+i);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }
    @RequestMapping("selectdistrict")
    @ResponseBody
    public List<District> selectByExample(){
        List<District> districts = districtService.selectdistrict();
        System.out.println("disCon:"+districts);
        return districts;
    }
    @RequestMapping("getDistrictByPage")
    @ResponseBody
    public Map<String,Object> getDistrictByPage(PageUtills pageUtills){
        PageInfo<District> districtByPage = districtService.getDistrictByPage(pageUtills);
        System.out.println("pageutil:"+pageUtills);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows",districtByPage.getList());
        System.out.println("集合："+districtByPage.getList());
        map.put("total",districtByPage.getTotal());
        System.out.println("pageUtiles:");
        return map;
    }

    //删除区域
    @RequestMapping("delDistrit")
    @ResponseBody   //{"result":0}
    public Map<String,Object> delDistrit(Integer id){
        //调用业务
        int flag=0;
        try{
            flag=districtService.delDistrict(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("ddd:"+flag);
        //使用map封装返回的数据
        // return "{\"result\":"+flag+"}";  //手工拼的json
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result",flag);  //自动将对象转化为json
        return map;
    }
    //修改回显
    @RequestMapping("getDistrit")
    @ResponseBody
    public District selById(District district){
        return districtService.selById(district);
    }
    //修改区域
    @RequestMapping("upDistrit")
    @ResponseBody
    public Map<String,Object> upDistrit(District district){
        int i;
        if (district.getName()!=null&&district.getName().length()!=0){
            i=districtService.upDistrit(district);
        }else {
            i =2;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result",i);
        System.out.println(i);
        return map;
    }

}
