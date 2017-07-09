/**
 * 
 */
package com.cn.pmqin.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.pmqin.dao.UserInfoMapper;
import com.cn.pmqin.domain.UserInfo;
import com.cn.pmqin.service.UserService;

/** 
* @author : pmqin
* @date   : 2016年3月14日 下午9:37:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
@Service("userService")
public class UserServiceImp {

	/**
	 * 自动装配 使用@Autowired注解标注userInfoMapper变量，
	 * 当需要使用userInfoMapper时，Spring就会自动注入userInfoMapper
	 */
	@Autowired
	private UserInfoMapper userInfoMapper;


	public UserInfo getUserById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}


	public int insert(UserInfo userInfo) {
		int result = userInfoMapper.insert(userInfo);

		System.out.println(result);
		return result;
	}


	public List<UserInfo> getUsers() {

		return userInfoMapper.getAllUser();

	}


	public List<UserInfo> list(int pageNum, int pageSize) {
		
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("pageNum", pageNum);
        parameterMap.put("pageSize",pageSize);
        //xml里面的占位符就是就是这个里面的key
		return userInfoMapper.getAllUsersByPageSize(parameterMap);
	}


	public int getAllCount() {
		return userInfoMapper.selectCount_user();
	}

}
