/**
 * 
 */
package com.cn.pmqin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/** 
* @author : pmqin
* @date   : 2016年9月25日 下午8:37:48 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
@Controller
public class MenuController {

	@RequestMapping("menu")
	public String ShowName(ModelMap model) {

		List<String> iList=new ArrayList<String>();
		return "menu";
		

	}
	
	//在方法定义上使用 @ModelAttribute 注解：Spring MVC 在调用目标处理方法前，会先逐个调用在方法级上标注了
	@ModelAttribute("Itemstypes")
	public Map<String, String> getItems() {
		
		Map<String, String> items=new HashMap<>();
		items.put("101", "测试");
		items.put("102", "测试1");
		items.put("103", "测试2");
		items.put("104", "测试2");
		return items;
	}
	
}
