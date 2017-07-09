package com.cn.pmqin.user.dao;

import com.cn.pmqin.user.model.User;

public interface IUserDao {
   
	public void AddUser(User user);
	
	public User GetUserByID(Integer id);
}
