/**
 * 
 */
package com.cn.pmqin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.pmqin.dao.UserDao;
import com.cn.pmqin.domain.UserInfo;
import com.cn.pmqin.imp.UserServiceImp;
import com.cn.pmqin.service.UserService;

/** 
* @author : pmqin
* @date   : 2016年3月14日 下午10:20:55 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImp userService;

	@RequestMapping("/showInfo/{userId}")
	public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
		UserInfo userInfo = userService.getUserById(userId);
		modelMap.addAttribute("userInfo", userInfo);
		return "showInfo";//htmls
	}

	@RequestMapping("/showInfos")
	public @ResponseBody Object showUserInfos() {
		List<UserInfo> userInfos = userService.getUsers();
		return userInfos;
	}

	@RequestMapping(value="/index")
	public String index(Model m) {
		UserDao dal = new UserDao();
		m.addAttribute("result",
				"I use mybatis find " + dal.GetUsersAll(5).getUsername() + " of data, My name is Mcqueen Xing.");
		return "index";
	}
	
	@RequestMapping("/showInfos/{pagNum}")
	public String  showpagSizeUserInfos(ModelMap modelMap, @PathVariable int pagNum) {
		if (pagNum<=0) {
			pagNum=1;
		}
		int offset=2*(pagNum-1);//offset=pageSize*(pagNum-1) 初始记录行的偏移量是 0(而不是 1)：
		List<UserInfo> userInfos = userService.list(offset, 2);
		modelMap.addAttribute("userInfos", userInfos);
		return "userlist";
	}
}
