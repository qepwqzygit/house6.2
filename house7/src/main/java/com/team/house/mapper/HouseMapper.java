package com.team.house.mapper;

import com.team.house.entity.EHouse;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.utills.ListPageUtil;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    /*查询发布的所有信息*/
    List<House> selEHouse(Integer userid);

    /*显示修改信息*/
    House selEHouseById(String id);

    /*查询房源*/
    List<EHouse> selEHouseByState(Integer state);

    /*查询所有  测试*/
    List<House> ah();

    /*looker 查看*/
    List<House> listHouse(ListPageUtil listPageUtil);

}