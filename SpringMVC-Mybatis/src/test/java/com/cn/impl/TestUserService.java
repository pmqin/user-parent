/**
 * 
 */
package com.cn.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.cn.pmqin.dao.UserDao;
import com.cn.pmqin.domain.UserInfo;
import com.cn.pmqin.service.UserService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* @author : pmqin
* @date   : 2016年3月14日 下午10:12:04 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestUserService {
	private static final Logger LOGGER = Logger.getLogger(TestUserService.class);

	//@Autowired
	@Qualifier("userService")
	private UserService userService;

	// private UserService userService;
	/**
	 * 这个before方法在所有的测试方法之前执行，并且只执行一次 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	 * 比如在before方法里面初始化ApplicationContext和userService
	 */
	// @Before
	// public void before(){
	// //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
	// ApplicationContext ac = new ClassPathXmlApplicationContext(new
	// String[]{"spring.xml","spring-mybatis.xml"});
	// //从Spring容器中根据bean的id取出我们要使用的userService对象
	// userService = (UserService) ac.getBean("userService");
	// }

	
	//注意每次改了后要install一下 才能保证修改成功，这样test才能ok
	@Test
	public void testQueryById1() {
//		UserInfo userInfo = userService.getUserById(1);
//		LOGGER.info(JSON.toJSON(userInfo));
		UserDao dal = new UserDao();
		UserInfo userInfo =dal.GetUsersAll(5);
		LOGGER.info(JSON.toJSON(userInfo));
	}

	@Test
	public void testQueryAll() {
		List<UserInfo> userInfos = userService.getUsers();
		LOGGER.info(JSON.toJSON(userInfos));
	}

	@Test
	public void testInsert() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("xiaoming");
		userInfo.setUsernumber(4);
		int result = userService.insert(userInfo);
		System.out.println(result);
	}
}
