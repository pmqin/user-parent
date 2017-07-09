package com.cn.pmqin.dao;

import java.util.List;
import java.util.Map;

import com.cn.pmqin.domain.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    
	List<UserInfo> getAllUser();
	
	List<UserInfo> getAllUsersByPageSize(Map para);
	
	int selectCount_user();
}