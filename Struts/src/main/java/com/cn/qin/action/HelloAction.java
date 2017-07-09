/**
 * 
 */
package com.cn.qin.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Result;

/** 
* @author : pmqin
* @date   : 2016年2月27日 下午10:10:13 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class HelloAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
//	@Action(value = "struts-test3")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// return super.execute();
		/**
		 * @parameter
		 */
		System.out.println("HelloAction execute() is called");

		return SUCCESS;
	}

	
//	http://localhost:8080/buding/struts-test    返回struts-test3.jsp前提是struts-test3.jsp在content目录下存在
	@Action(value = "struts-test", results = {@Result(name = "success", type = "dispatcher", location = "struts-test3.jsp") })

	public String list() throws Exception {

		return SUCCESS;

	}

}
