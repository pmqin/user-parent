/**
 * 
 */
package com.cn.pmqin.service;

import java.util.*;

import com.cn.pmqin.domain.UserInfo;

/** 
* @author : pmqin
* @date   : 2016年3月14日 下午9:27:23 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public interface UserService {
	UserInfo getUserById(int id);

	List<UserInfo> getUsers();

	int insert(UserInfo userInfo);

	List<UserInfo> list(int pageNum, int pageSize);

	int getAllCount();
}
