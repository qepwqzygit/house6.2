package com.team.house.service.impl;

import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:11:19
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> selType() {
        List<Type> typeList = typeMapper.selectByExample(new TypeExample());
        System.out.println("typeList serrvice:"+typeList);
        return typeList;
    }

}
