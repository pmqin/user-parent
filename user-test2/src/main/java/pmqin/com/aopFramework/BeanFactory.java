/**
 * 
 */
package pmqin.com.aopFramework;

import java.io.*;
import java.util.*;

/** 
* @author : pmqin
* @date   : 2016年4月30日 下午10:10:54 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class BeanFactory {

	Properties props = new Properties();

//	public BeanFactory(String fileName) {
//		try {
//			InputStream inputStream = new FileInputStream(fileName);
//			props.load(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public BeanFactory(String fileName) {
		try {
			InputStream ips = BeanFactory.class.getClassLoader().getResourceAsStream(fileName);
			//InputStream inputStream = new FileInputStream(fileName);
			props.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public BeanFactory(File file) {
		try {
			InputStream inputStream = new FileInputStream(file);
			props.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BeanFactory(InputStream ips) {
		try {
			props.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object getBean(String name) {
		Object bean = null;
		try {
			String strName=props.getProperty(name);
			System.out.println("BeanFactory得到了这个Key的完全限定名称："+strName);
			Class<?> class1 = Class.forName(strName);
			bean = class1.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bean instanceof ProxyBeanFactory){
			Object proxy = null;
			ProxyBeanFactory proxyFactoryBean = (ProxyBeanFactory)bean;
			try {
				Advice advice = (Advice)Class.forName(props.getProperty(name + ".advice")).newInstance();
				Object target = Class.forName(props.getProperty(name + ".target")).newInstance();
				proxyFactoryBean.setAdvice(advice);
				proxyFactoryBean.setTarget(target);
				proxy = proxyFactoryBean.getProxy();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return proxy;
		}
		return bean;

	}

	public <T> T getBean(String name, Class<T> requiredType) {
		T bean = null;
		try {
			Class<?> class1 = Class.forName(props.getProperty(name));
			bean =(T) class1.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;

	}
}
