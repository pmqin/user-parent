package com.cn.pmqin.dao;

import java.util.List;

import com.cn.pmqin.domain.CourseInfo;
import com.cn.pmqin.domain.UserInfo;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
    
}