/**
 * 
 */
package pmiqn.com.cn;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.*;

/** 
* @author : pmqin
* @date   : 2016年6月11日 下午4:16:06 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class BeanUtils {

	/***
	 * 获取bean里面所有的属性
	 * @param bean
	 * @return
	 */
	public static HashMap<String, Object> backupProp(Object bean) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			// 获得Bean描述
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			// 获得属性描述
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			// 遍历所有属性
			for (PropertyDescriptor des : descriptors) {
				// 属性名称
				String fieldName = des.getName();
				// 读取属性的方法
				Method getter = des.getReadMethod();
				// 读取属性值
				Object fieldValue = getter.invoke(bean, new Object[] {});
				if (!fieldName.equalsIgnoreCase("class")) {
					result.put(fieldName, fieldValue);
				}
			}
		} catch (Exception e) {
			// 异常处理
		}
		return result;
	}

	/***
	 * 将bean所有的值进行赋值
	 * @param bean
	 * @param propMap
	 */
	public static void restoreProp(Object bean, HashMap<String, Object> propMap) {
		try {
			// 获得Bean描述
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			// 获得属性描述
			
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			// 遍历所有属性
			for (PropertyDescriptor des : descriptors) {
				// 属性名称
				String fieldName = des.getName();
				// 如果有这个属性
				if (propMap.containsKey(fieldName)) {
					// 写属性的方法
					Method setter = des.getWriteMethod();
					setter.invoke(bean, new Object[] { propMap.get(fieldName) });
				}
			}
		} catch (Exception e) {
			// 异常处理
			System.out.println("shit");
			e.printStackTrace();
		}
	}
	
	/***
	 * 获取指定的属性值的写入方法
	 * @param bean
	 * @param propertyName
	 * @return
	 */
	public static Method getWriteMethod(Object bean, String propertyName) {
		Method setter=null;
		try {
			// 获得Bean描述
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			// 获得属性描述
			
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			// 遍历所有属性
			for (PropertyDescriptor des : descriptors) {
				// 属性名称
				String fieldName = des.getName();
				// 如果有这个属性
				if (propertyName.equals(fieldName)) {
					// 写属性的方法
					setter = des.getWriteMethod();
					
				}
			}
		} catch (Exception e) {
			// 异常处理
			System.out.println("shit");
			e.printStackTrace();
			throw new RuntimeException("Bean的属性"+propertyName+"没有对应的set方法");
		}
		return setter;
	}
}
