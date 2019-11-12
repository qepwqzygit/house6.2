package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.service.DistrictService;
import com.team.house.utills.PageUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:ZY
 * @date:${date}${time}
 */
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    //添加,先查找
    public int insertDistrict(District district) {
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andNameEqualTo(district.getName());
        List<District> list = districtMapper.selectByExample(districtExample);
        System.out.println("是否已经存在："+list.size());
        if (list.size()==1){
            return 0;
        }
        return districtMapper.insertSelective(district);
    }

    public List<District> selectdistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
        /*分页*/
    public PageInfo<District> getDistrictByPage(PageUtills pageUtills) {
        PageHelper.startPage(pageUtills.getPage(),pageUtills.getRows());
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);
        PageInfo<District> pageInfo = new PageInfo<District>(districts);
        return pageInfo;
    }



    //删除区域  删除街道  js  方法 没对应
    @Transactional(propagation = Propagation.REQUIRED)
    public int delDistrict(Integer id) {
        int temp=0;
        //1.通过区域道编号删除街   //编写dao层
        districtMapper.deleteStreetByDistrict(id);
        temp++;
        //int i=9,j=0;   i=i/j;
        //2.删除区域
        districtMapper.deleteByPrimaryKey(id);
        temp++;
        return temp;
    }
    //修改回显
    public District selById(District district) {
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andIdEqualTo(district.getId());
        System.out.println("要修改的id"+district.getId());
        return districtMapper.selectByExample(districtExample).get(0);
    }
    //修改
    public int upDistrit(District district){
        DistrictExample districtExample = new DistrictExample();
        DistrictExample.Criteria criteria = districtExample.createCriteria();
        criteria.andIdEqualTo(district.getId());
        criteria.andNameEqualTo(district.getName());
        System.out.println("要修改的："+district.getName());
        return districtMapper.updateByPrimaryKeySelective(district);
    }

}
