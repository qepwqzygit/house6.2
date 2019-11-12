package com.team.house.pController;

import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:11:34
 */
@Controller("districtController2")
@RequestMapping("/page")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getAllDistrict")
    @ResponseBody
    public List<District> selDistrict(){
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtService.selectdistrict();
        System.out.println("DisCont:"+districts);
        return districtService.selectdistrict();
    }


}
