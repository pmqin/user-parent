package com.cn.pmqin.user.dao;
import com.cn.pmqin.user.model.User;
import com.cn.pmqin.user.util.HibernateUtil;

public class UserDao implements IUserDao {

	public void AddUser(User user) {
		
		HibernateUtil.insert(user);
	}

	
	public User GetUserByID(Integer id) {
		String strSQL="from User where ID="+id;
		User user=(User)HibernateUtil.getRecorderByKey(strSQL, true);
		return user;
	}

}
