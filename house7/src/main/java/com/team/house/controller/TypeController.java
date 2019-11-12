package com.team.house.controller;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:19:02
 */
@Controller
@RequestMapping("admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("selAllType")
    @ResponseBody
    public List<Type> selType(){
        System.out.println("typeList contro:"+typeService.selType());
        return typeService.selType();
    }
}
