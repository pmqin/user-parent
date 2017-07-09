package pmqin.servlet;

import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class BindingListener
 *
 */
@WebListener
public class BindingListener implements HttpSessionBindingListener {

    /**
     * Default constructor. 
     */
    public BindingListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
         System.out.println("["+new Date()+"]"+event.getName()+"解綁:"+event.getSession().getId());
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
    	 System.out.println("["+new Date()+"]"+event.getName()+"綁定:"+event.getSession().getId());
    }
	
}
