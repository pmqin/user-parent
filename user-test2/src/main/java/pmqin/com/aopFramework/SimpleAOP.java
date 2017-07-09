/**
 * 
 */
package pmqin.com.aopFramework;


import java.io.InputStream;
import java.util.Observable;

import pmiqn.com.Service.Hello;
import pmqin.com.IService.IHello;
import pmqin.com.test.MyTest;

/** 
* @author : pmqin
* @date   : 2016年4月30日 下午10:11:26 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class SimpleAOP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputStream ips = SimpleAOP.class.getClassLoader().getResourceAsStream("confBean.properties");
		//InputStream ips = SimpleAOP.class.getResourceAsStream("confBean.properties"); 一般模式的加载
		BeanFactory factory=new BeanFactory("confBean.properties");//但是最好不要这样，因为文件名称不确定因素，最好用输入流参数的形式
//		MyTest test=(MyTest)factory.getBean("test");
//		test.setName("自己实现Spring的BeanFactory");
//		Hello test=factory.getBean("test",Hello.class);
//		test.hello();
		
		
		IHello bean = (IHello)new BeanFactory(ips).getBean("test");
		
		System.out.println(bean.getClass().getName());
		bean.hello();
				
	}

}
