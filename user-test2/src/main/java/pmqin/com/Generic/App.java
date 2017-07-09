/**
 * 
 */
package pmqin.com.Generic;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import pmqin.com.test.test2;

/** 
* @author : pmqin
* @date   : 2016年4月21日 下午11:13:50 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericDao<test2> dao=new GenericDao<test2>();
		dao.add(new test2());
		
		
	}
	
	
	//通过反射获取到泛型的实际类型，这个有一点像orm的样子，他知道你的返回值的类型是什么，自己去加载你定义的类型
	private static void SetProperties(Object obj,String propertyName) {
		
//		PropertyDescriptor pd2=new  PropertyDescriptor(propertyName,obj.getClass());
//		Method metset=pd2.getWriteMethod();
		//metset.invoke(obj, null);
		
	}
}
