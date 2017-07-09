/**
 * 
 */
package pmqin.com.aopFramework;

import java.lang.reflect.Method;

/** 
* @author : pmqin
* @date   : 2016年6月10日 下午9:13:06 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class MyAdvice implements Advice {

	long beginTime = 0;
	/* (non-Javadoc)
	 * @see pmqin.com.aopFramework.Advice#beforeMethod(java.lang.reflect.Method)
	 */
	@Override
	public void beforeMethod(Method method) {
		System.out.println("beforeMethod成功拦截！");		
		beginTime = System.currentTimeMillis();
		
	}

	/* (non-Javadoc)
	 * @see pmqin.com.aopFramework.Advice#afterMethod(java.lang.reflect.Method)
	 */
	@Override
	public void afterMethod(Method method) {
		System.out.println("afterMethod结束了！");
		long endTime = System.currentTimeMillis();
		System.out.println(method.getName() + " running time of " + (endTime - beginTime));
	}

}
