/**
 * 
 */
package com.cn.qin.interceptor;
import com.opensymphony.xwork2.ActionInvocation;  
import com.opensymphony.xwork2.interceptor.Interceptor;

/** 
* @author : pmqin
* @date   : 2016年2月27日 下午10:08:54 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class PrintMessageInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		/** 
		* @parameter  
		*/
		System.out.println("destory() method is invoked");  
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		/** 
		* @parameter  
		*/
		System.out.println("init() method is invoked");  
	}

	@Override 
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("before invocation.invoked..........");  
        String result = invocation.invoke();  
        System.out.println(result);  
        System.out.println("after  invocation.invoked..........");  
        return  result;  
	}

}
