package pmqin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//http://haohaoxuexi.iteye.com/blog/2013691
@WebServlet("/sessiona")//不需要在web.xml里面配置，名称和类名都可以访问
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		session.setAttribute("属性1", "属性1的值");
		session.setAttribute("属性2", "属性2的值");
		session.setAttribute("属性3", "属性3的值");
		session.setAttribute("属性4", "属性4的值");
		
		Enumeration<String>  attribute= session.getAttributeNames();
		String name;
		out.println("<H5>原来的属性</H5>"); 
		while (attribute.hasMoreElements()) {
			name = (String) attribute.nextElement();
			out.println(name+"-->"+session.getAttribute(name)+"</br>");
			
		}
		out.println("<H5>删除属性1和属性2</H5>");
		session.setAttribute("属性1", null);
		session.removeAttribute("属性2");
		session.setAttribute("属性4", "替換了屬性4");
		
		out.println("<H5>删除后的属性</H5>");
		Enumeration<String>  attributes= session.getAttributeNames();
		
		
		while (attributes.hasMoreElements()) {
			name = (String) attributes.nextElement();
			out.println(name+"-->"+session.getAttribute(name)+"</br>");
			
		} 
		 String sessionId = session.getId();
		 //判断session是不是新创建的
		 if (session.isNew()) {
			 response.getWriter().print("session创建成功，session的id是："+sessionId);
		 }
		 else {
			  response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
		}
		out.println("當前回話的總數："+SessionCounter.getActivecount());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//WebUtils工具（org.springframework.web.util.WebUtils）的 
	//getSessionAttribute(HttpServletRequest request, String name)方法
	public static Object getSessionAttribute(HttpServletRequest request, String name) {  

	    //Assert.notNull(request, "Request must not be null");  

	    HttpSession session = request.getSession(false);  

	    return (session != null ? session.getAttribute(name) : null);  

	}  

}
