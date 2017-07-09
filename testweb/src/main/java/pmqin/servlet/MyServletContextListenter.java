package pmqin.servlet;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletConfigListenter
 *
 */
@WebListener
public class MyServletContextListenter implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public MyServletContextListenter() {
		// TODO Auto-generated constructor stub
	}

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 

//创建线程池
//    	ThreadPoolExecutor executor=new ThreadPoolExecutor(100, 100, 5000L, TimeUnit.MILLISECONDS, 
//    			new  ArrayBlockingQueue<Runnable>(100));
//    	
//    	sce.getServletContext().setAttribute("executor", executor);
    	System.out.println("MyServletContextInitialized"+sce.getServletContext());
    }

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextDestroyed");
		//关闭线程池
//		ThreadPoolExecutor executor=(ThreadPoolExecutor)sce.getServletContext().getAttribute("executor");
//		executor.shutdown();
	}

}
