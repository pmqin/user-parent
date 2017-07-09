/**
 * 
 */
package pmqin.com.aopFramework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
* @author : pmqin
* @date   : 2016年4月30日 下午10:35:05 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ProxyBeanFactory {

	private Advice advice;
	private Object target;
	
	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getProxy() {		
		Object proxyInstance = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler(){
				
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;						
						
					}
				}
				);
		return proxyInstance;
	}
}
