package pmqin.servlet;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class MyAsyncListener
 *
 */
public class MyAsyncListener implements AsyncListener {

	/* (non-Javadoc)
	 * @see javax.servlet.AsyncListener#onComplete(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		  System.out.println("异步调用完成……");  
	         event.getSuppliedResponse().getWriter().println("异步调用完成……");  
	}

	/* (non-Javadoc)
	 * @see javax.servlet.AsyncListener#onTimeout(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		 System.out.println("异步调用超时……");  
         event.getSuppliedResponse().getWriter().println("异步调用超时……");  
	}

	/* (non-Javadoc)
	 * @see javax.servlet.AsyncListener#onError(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("异步调用出错……");  
        event.getSuppliedResponse().getWriter().println("异步调用出错……"); 
	}

	/* (non-Javadoc)
	 * @see javax.servlet.AsyncListener#onStartAsync(javax.servlet.AsyncEvent)
	 */
	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("异步调用开始……");  
        event.getSuppliedResponse().getWriter().println("异步调用开始……");  
	}

    
}
