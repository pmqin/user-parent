package pmqin.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 每次客户端的请求都会执行初始化和销毁方法
 *
 */
public class ServletRequestListerter implements ServletRequestListener {

	 
    /**
     * Default constructor. 
     */
    public ServletRequestListerter() {
    	System.out.println("ServletRequestListerter初始化");//这个只是一次
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("requestDestroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("应用启动了请求ServletRequest");
    }
	
}
