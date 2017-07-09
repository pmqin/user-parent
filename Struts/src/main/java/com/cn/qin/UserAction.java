/**
 * 
 */
package com.cn.qin;

import com.opensymphony.xwork2.ActionSupport;

/** 
* @author : pmqin
* @date   : 2016年2月27日 下午9:17:06 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute(){  
		//username="hjkhdkjashfjkas"; 
		if ("Admin".equals(username)) {
			return SUCCESS;
		}
        return "LOGIN";  
    } 
}
