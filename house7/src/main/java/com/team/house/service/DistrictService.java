package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.utills.PageUtills;

import java.util.List;

/**
 * @author:ZY
 * @date:${date}${time}
 */
public interface DistrictService {

    //添加,先查找
    int insertDistrict(District district);

    List<District> selectdistrict();

    PageInfo<District> getDistrictByPage(PageUtills pageUtills);

    //删除区域
     int delDistrict(Integer id);

     //修改回显
    District selById(District district);
    //修改
    int upDistrit(District district);

}
