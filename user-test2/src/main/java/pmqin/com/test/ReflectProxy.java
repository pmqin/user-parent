/**
 * 
 */
package pmqin.com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Date;

/** 
* @author : pmqin
* @date   : 2016年4月5日 下午11:48:32 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Array;

import pmiqn.com.Service.Hello;
import pmqin.com.IService.IHello;

public class ReflectProxy extends Date {
	private  void getBillName() {
		System.out.println(this.getClass().getName());
		System.out.println(super.getClass().getName());
		System.out.println(super.getClass().getSuperclass().getName());
		
	}
	public static void main(String[] args) throws Exception {
		ReflectProxy proxy=new  ReflectProxy();
		proxy.getBillName();
		
		// 虚拟机为每个类型管理一个Class类型的对象。因此，可以用==运算符实现两个类对象比较的操作。
		System.out.println(Object.class);
		String str11 = "abc";
		Class strcls1 = str11.getClass();
		Class strcls2 = String.class;
		Class strcls3 = Class.forName("java.lang.String");// 内存中只有一份相同类型的字节码
		System.out.println(strcls1 == strcls2);
		System.out.println(strcls1 == strcls3);
		System.out.println("字符串不是基本类型？" + strcls1.isPrimitive());
		Boolean var1 = true;
		Class<?> classType2 = var1.getClass();
		System.out.println(classType2);
		Integer var3 = 1;
		Class<?> classType3 = var3.getClass();
		System.out.println("Integer.Class=" + classType3);
		// 一个Class对象实际上表示的是一个类型，而这个类型未必一定是一种类。例如，int不是类，但int.class是一个Class类型的对象

		Class<?> classType4 = int.class;
		System.out.println("int.class=" + classType4+"------------"+classType4.getSimpleName());
		int[] ints = new int[2];
		Class<?> arrayClass = ints.getClass();
		System.out.println(arrayClass);
		System.out.println("得到数组是什么类型");
		System.out.println(arrayClass.getName()+"---------testInit.getClass().-------------"+arrayClass.getClass().getSimpleName());
		System.out.println(arrayClass.isPrimitive());
		System.out.println(arrayClass.getComponentType());// 得到数组是什么类型
		System.out.println(arrayClass.getComponentType().isPrimitive());
		System.out.println(arrayClass.getComponentType() == int.class); // 内存中只有一份相同类型的字节码
		System.out.println("Integer.class== int.class:?" + (Integer.class == int.class)); // 用这个判断最好
		// http://www.cnblogs.com/rollenholt/archive/2011/09/02/2163758.html

		// Class类对象就是该类在内存中的字节码，就是类的引用
		Class<?> testClassInstance = Class.forName("pmqin.com.test.test2");

		test2 testInit = (test2) testClassInstance.newInstance();
		testInit.setId(12);
		System.out.println(testInit);
		
		System.out.println("--getClass().getName--"+testInit.getClass().getName()+"---------testInit.getClass().-------------"+testInit.getClass().getSimpleName());
		System.out.println("--getClass()--"+testInit.getClass());
		
		Method method = testClassInstance.getMethod("getName");
		System.out.println(method.invoke(testInit));

		method = testClassInstance.getDeclaredMethod("GetTestName");
		method.setAccessible(true);
		System.out.println(method.invoke(testInit));

		method = testClassInstance.getMethod("setName", String.class);
		method.invoke(testInit, "Rollen");
		System.out.println(testInit);

		Method logMethod = testClassInstance.getDeclaredMethod("setName", String.class);
		logMethod.invoke(testInit, "测试getDeclaredMethod");
		System.out.println(testInit);

		System.out.println(method.getDeclaringClass());
		System.out.println(method.getDeclaringClass().getName());
		System.out.println(method.getClass().getName());
		System.out.println(method.getName());

		// if (Object.class.equals(method.getDeclaringClass())) {
		if (test2.class.equals(method.getDeclaringClass())) {
			method.invoke(testInit, "比较");
			System.out.println(testInit);

		}
		System.out.println(method.getName());
		System.out.println(method.getModifiers());

		// 取得全部的构造函数
		// Constructor<?> cons[]=demo.getConstructors();
		// try{
		// per1=(Person)cons[0].newInstance();
		// per2=(Person)cons[1].newInstance("Rollen");
		// per3=(Person)cons[2].newInstance(20);
		// per4=(Person)cons[3].newInstance("Rollen",20);
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		Constructor<?> cons[] = testClassInstance.getConstructors();
		for (int i = 0; i < cons.length; i++) {
			Class<?> p[] = cons[i].getParameterTypes();
			System.out.print("构造方法：  ");
			int mo = cons[i].getModifiers();
			System.out.print(Modifier.toString(mo) + " ");
			System.out.print(cons[i].getName());
			System.out.print("(");
			for (int j = 0; j < p.length; ++j) {
				System.out.print(p[j].getName() + " arg" + i);
				if (j < p.length - 1) {
					System.out.print(",");
				}
			}
			System.out.println("){}");
		}

		//用instancof来测试它所指向的对象是否是Object类的一个实例 或者本身
		ReflectProxy outer=new ReflectProxy();
		
		Bill phoneBill =  outer.new PhoneBill();
		Bill gasBill = outer.new GasBill();
		if (gasBill instanceof PhoneBill) {
			System.out.println("gasBill instanceof PhoneBill");
		}
		if (phoneBill instanceof PhoneBill) {
			System.out.println("phoneBill instanceof PhoneBill");
		}
		calculate(phoneBill);
		calculate(gasBill);
		

	}

	public class Bill extends Date {
		
		private  void getBillName() {
			System.out.println(super.getClass().getName());
			
		}
	}

	public class PhoneBill extends Bill {
	}

	public class GasBill extends Bill {
	}

	public  static boolean calculate(Bill bill) {
		bill.getBillName();
		if (bill instanceof PhoneBill)
		{
			System.out.println("bill instanceof PhoneBill");
		}
		if (bill instanceof GasBill) {
			System.out.println("bill instanceof GasBill");
		}
    	return true;
    	
    }

	/**
	 * 判断是否为某个类的实例
	 * 
	 * @param obj
	 * @param cls
	 * @return
	 */
	public boolean isInstance(Object obj, Class cls) {
		return cls.isInstance(obj);
	}

	// public Object getByArray(Object array, int index) {
	// return Object(array, index);
	// }

	@Test
	public void testProxy() throws Exception {
		final IHello hello = new Hello();

		/*
		 * proxyHello : 代理主题角色，代理类的实例 IHello :
		 * 抽象主题角色，代理类和被代理类都需要实现的接口，JDK中的动态代理必须针对接口 hello : 真实主题角色，被代理类的实例
		 */
		IHello proxyHello = (IHello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { IHello.class }, new InvocationHandler() {

					/*
					 * @param proxy : 当前代理类的一个实例；
					 * 若在invoke()方法中调用proxy的非final方法，将造成无限循环调用.
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						// 前置的业务逻辑操作
						System.out.println("---开始");

						// 调用被代理类的方法，传入参数args，得到返回
						Object object = method.invoke(hello, args);

						// 后置的业务逻辑操作
						System.out.println("---结束");

						return object;
					}
				});

		proxyHello.hello();
	}
}
