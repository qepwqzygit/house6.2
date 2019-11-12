package com.team.house.service;

import com.team.house.entity.Street;

import java.util.List;

/**
 * @author:ZY
 * @date:2019/10/22
 * @Time:11:37
 */
public interface StreetService {
    List<Street> selByDid(Integer districtId);


}
