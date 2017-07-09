package pmqin.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Application Lifecycle Listener implementation class MyServletConfigAttributeListenter
 *
 */
public class MyServletContextAttributeListenter implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletContextAttributeListenter() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent event)  { 
        System.out.println("ServletContextattributeAdded('"+event.getName()+"','"+event.getValue()+"')");
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event)  { 
    	 System.out.println("ServletContextattributeReplaced('"+event.getName()+"','"+event.getValue()+"')");
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent event)  { 
    	String dd=event.getName();
    	System.out.println("ServletContextattributeRemoved("+dd+","+event.getValue()+")");
    }
	
}
