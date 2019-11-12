package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.EHouse;
import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.utills.ListPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/23
 * @Time:16:26
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    public int insertHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    public List<House> selEHouse(Integer userid) {
        return houseMapper.selEHouse(userid);
    }

    public House selEHouseById(String id) {
        return houseMapper.selEHouseById(id);
    }

    public int updateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public int deleteHouseById(String id, Integer state) {
        House house = new House();
        house.setId(id);
        house.setIsdel(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public List<EHouse> selEHouseByState(Integer state) {
        return houseMapper.selEHouseByState(state);
    }

    public List<House> ah() {
        return houseMapper.selectByExample(new HouseExample());
    }

    public int goPass(String id,Integer state) {
        House house = new House();
        house.setId(id);
        house.setIspass(state);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> listHouse(ListPageUtil listPageUtil) {
        PageHelper.startPage(listPageUtil.getPage(),listPageUtil.getRows());
        return new PageInfo<House>(houseMapper.listHouse(listPageUtil));
    }

}
