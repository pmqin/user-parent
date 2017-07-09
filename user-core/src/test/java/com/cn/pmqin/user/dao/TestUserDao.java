/**
 * 
 */
package com.cn.pmqin.user.dao;

import org.junit.Test;

import com.cn.pmqin.user.model.User;

/** 
* @author : pmqin
* @date   : 2015年12月27日 下午7:12:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestUserDao {
	private IUserDao userDao;

	@Test
	public void setUp() {
		userDao = new UserDao();
		User user = new User("123456", "qinpmq", "上海市");
		userDao.AddUser(user);

	}

}
