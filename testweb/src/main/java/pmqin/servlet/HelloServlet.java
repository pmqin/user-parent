/**
 * 
 */
package pmqin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.pmqin.user.model.ProductInfos;


public class HelloServlet extends HttpServlet {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("user", new  pmqin.model.User(1,"admin1", "上海", "13543222232"));
		
		
		
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
	}
}
