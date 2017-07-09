package pmqin.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 
 * Servlet3.0支持使用注解配置Servlet。我们只需在Servlet对应的类上使用@WebServlet进行标注， 
 * 我们就可以访问到该Servlet了，而不需要再在web.xml文件中进行配置。@WebServlet的urlPatterns 
 * 和value属性都可以用来表示Servlet的部署路径，它们都是对应的一个数组。 
 */ 
/** 
 * 带初始化参数的Servlet 
 * WebServlet的属性initParams可以用来指定当前Servlet的初始化参数，它是一个数组， 
 * 里面每一个@WebInitParam表示一个参数。 
 */ 
@WebServlet(value = "/servlet/init-param", initParams = { @WebInitParam(name = "param1", value = "value1")
,@WebInitParam(name = "param2", value = "value2")
})
public class WebInitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> paramNames = this.getServletConfig().getInitParameterNames();
		String paramName;
		while (paramNames.hasMoreElements()) {
			paramName = paramNames.nextElement();
			response.getWriter().append(paramName + " = " + this.getServletConfig().getInitParameter(paramName));
		}
		response.getWriter().close();
	}

}
