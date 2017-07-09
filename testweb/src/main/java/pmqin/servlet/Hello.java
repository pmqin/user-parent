package pmqin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.math.BigDecimal;
import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// implements SingleThreadModel
public class Hello extends HttpServlet {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("HelloDestroy");
		
		
		
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Helloinit");
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        System.out.println("Hello初始化");
        // TODO Auto-generated constructor stub
    }
    int i=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		i++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//构造指定的Servlet对象，创建ServletConfig对象
		ServletConfig config=  this.getServletConfig();
		System.out.println(config.getInitParameter("qinpengming"));		
		System.out.println(config.getServletName());
		//InvocationHandler
		//范围在应用层面，直到重启服务的时候会销毁  初始化的属性
		ServletContext context=this.getServletContext();
		System.out.println(context.getInitParameter("qin"));
		//config里面也有这个
		ServletContext servletContext=config.getServletContext();
		System.out.println(servletContext.getInitParameter("qin"));
		
//		5.读取资源的配置文件。
//		ServletContext context = this.getServletContext();
//		
//		InputStream inputStream = context.getResourceAsStream("/db.properties");
//		
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		byte[] by = new byte[1024];
//		int len = 0;
//		
//		while((len = inputStream.read(by))!= -1){
//			outStream.write(by, 0, len);
//		}
//		
//		String content = new String(outStream.toByteArray());
//		System.out.println("content------------->"+content);
//		
//		outStream.close();
//		inputStream.close();
		//XmlWebApplicationContext dd=new XmlWebApplicationContext();
		
		System.out.println(BigDecimal.ZERO);
		System.out.println(BigDecimal.valueOf(0.0));
		PrintWriter out=response.getWriter();
		out.println("测试ServletContextAttributeListenter");
		getServletContext().setAttribute("peng", "监听到了ServletContextAttributeListenter增加");
		getServletContext().setAttribute("peng", "监听到了ServletContextAttributeListenter修改");
		getServletContext().removeAttribute("peng");
		// 对应的获取用String hiveGroupsFile=(String)context.getAttribute("hiveGroupsFile");
		response.getWriter().append("Servweweed at: "+i).append(request.getContextPath());
		//http://localhost:8080/testweb/Hello 地址不会改变
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
