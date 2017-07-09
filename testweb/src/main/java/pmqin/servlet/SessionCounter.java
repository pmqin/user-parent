package pmqin.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * sessionCreated//新建一个会话时候触发也可以说是客户端第一次和服务器交互时候触发 
 * sessionDestroyed//销毁会话的时候  * 一般来说只有某个按钮触发进行销毁 或者配置定时销毁
 *
 */
@WebListener
public class SessionCounter implements HttpSessionListener, HttpSessionAttributeListener {
	// 参数
	ServletContext sc;
	private static int activecount = 0;
	// 定义监听的session属性名.
	public final static String LISTENER_NAME = "userName";
	// 定义存储客户登录session的集合.
	private static ArrayList list = new ArrayList();

	public static int getActivecount() {
		return activecount;
	}

	public static void setActivecount(int activecount) {
		SessionCounter.activecount = activecount;
	}

	public SessionCounter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see 新建一个会话时候触发也可以说是客户端第一次和服务器交互时候触发 
	 */
	public void sessionCreated(HttpSessionEvent se) {
		activecount++;
		sc = se.getSession().getServletContext(); // 这个给力,用于前端获取结果
		System.out.println("新建一个session" + se.getSession().getId());
	}

	// 销毁一个session时触发此操作 一般来说只有某个按钮触发进行销毁 或者配置定时销毁
	// 方法1 request.getSession().removeAttribute("userName");
	// 方法2 session.invalidate();
	public void sessionDestroyed(HttpSessionEvent se) {

		activecount--;
		
		System.out.println("销毁一个session=" + se.getSession().getId());
		if (!list.isEmpty()) {
			list.remove((String) se.getSession().getAttribute("userName"));
			sc.setAttribute("list", list);// 更新
		}

	}

	/*
	 * (non-Javadoc) 在session中添加对象时触发此操作，在list中添加一个对象
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if (LISTENER_NAME.equals(event.getName())) {
			System.out.println("有用户进来了--" + event.getValue());
			
			// 判断存入的对象是否包含在list中，如果已包含则不添加
			if (!list.contains((String) event.getValue())) {
				activecount++;
				list.add((String) event.getValue());
				sc.setAttribute("list", list);
			}
			//也可以存sessionid 来判断
			 // 判断存入的对象是否包含在list中，如果已包含则不添加
//            boolean bl = true;
//            for (int i = 0; i < getSessions().size(); i++) {
//                if(getSessions().get(i).getId().equals(member.getId())){
//                    bl = false;
//                    break;
//                }
//            }
//            if(bl){
//                sessions.add(member);
//            }

		}
	}

	/*
	 * session失效时的监听方法 // 注销用户和使session失效(超时)。//方法1 request.getSession().removeAttribute("userName");
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		  if (LISTENER_NAME.equals(event.getName())) { 
			 
			  if (!list.isEmpty()) {
				    activecount--;
					list.remove((String)event.getValue());
					sc.setAttribute("list", list);// 更新
				}
			  
			  System.out.println("注销用户"+event.getSession().getId()); 
	        }
		
	}

	/*
	 * 在Session属性被重新设置时
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.
	 * servlet.http.HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("attributeReplaced");
	}

}
