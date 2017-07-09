/**
 * 
 */
package pmqin.com.aopFramework;

import java.lang.reflect.Method;

/** 
* @author : pmqin
* @date   : 2016年6月10日 下午9:12:18 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public interface  Advice {
	void beforeMethod(Method method);
	void afterMethod(Method method);
}
