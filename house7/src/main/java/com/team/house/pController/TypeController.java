package com.team.house.pController;

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
 * @Time:11:21
 */
@Controller("TypeController")
@RequestMapping("page")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("selType")
    @ResponseBody
    public List<Type> selType(){
        List<Type> typeList = typeService.selType();
        System.out.println("pcontro:"+typeList);
        return typeList;
    }
}
