package com.team.house.pController;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:11:39
 */
@Controller()
@RequestMapping("page")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getAllStreetById")
    @ResponseBody
    public List<Street> getAllStreet(Integer did){
        System.out.println("pCst:"+ did);
        return streetService.selByDid(did);

    }
}
