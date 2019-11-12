package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.EHouse;
import com.team.house.entity.House;
import com.team.house.utills.ListPageUtil;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/23
 * @Time:16:25
 */
public interface HouseService {

    int insertHouse(House house);

    List<House> selEHouse(Integer userid);

    /*显示修改信息*/
    House selEHouseById(String id);

    /*修改*/
    int updateHouse(House house);

    /*逻辑删除*/
    int deleteHouseById(String id,Integer state);

    /*查询房源*/
    List<EHouse> selEHouseByState(Integer state);

    List<House> ah();

    /*审核*/
    int goPass(String id,Integer state);
    /*looker 查看*/
    PageInfo<House> listHouse(ListPageUtil listPageUtil);
}
