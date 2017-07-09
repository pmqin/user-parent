package com.cn.pmqin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cn.pmqin.domain.UserInfo;
import com.cn.pmqin.service.UserService;

/**
 * @author 
 * @WebServlet是Servlet3.0提供的注解，目的是将一个继承了HttpServlet类的普通java类标注为一个Servlet
 * UserServlet使用了@WebServlet标注之后，就不需要在web.xml中配置了
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有的用户信息
        List<UserInfo> lstUsers = userService.getUsers();
        request.setAttribute("lstUsers", lstUsers);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 public void init() throws ServletException {
	        //在Servlet初始化时获取Spring上下文对象(ApplicationContext)
	        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	        //从ApplicationContext中获取userService
	        userService = (UserService) ac.getBean("userService");
	    }

}
