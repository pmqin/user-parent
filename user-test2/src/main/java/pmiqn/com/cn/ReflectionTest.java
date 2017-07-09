/**
 * 
 */
package pmiqn.com.cn;

import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;
import org.junit.Test;

import pmqin.com.algorithms.SortClass;
import pmqin.com.test.AbstractClassImp;
import pmqin.com.test.abstractClass;
import pmqin.com.test.hashcodetest;

/** 
* @author : pmqin
* @date   : 2016年3月26日 下午4:32:52 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ReflectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		Class<?> demo4 = null;
		Class<?> demo5 = null;
		try {
			// 一般尽量采用这种形式
			//demo1 = Class.forName("pmqin.com.test.abstractClass");
			demo4 = Class.forName("pmqin.com.test.test4");
			demo5 = Class.forName("pmqin.com.test.AbstractClassImp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//demo2 = new AbstractClassImp().getClass();
		demo3 = abstractClass.class;

		//System.out.println("类名称   " + demo1.getName());
		//System.out.println("类名称   " + demo2.getName());
		System.out.println("类名称   " + demo3.getName());
		hashcodetest per = null;
		AbstractClassImp per1 = null;

		try {
			per = (hashcodetest) demo4.newInstance();
			per1 = (AbstractClassImp) demo5.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
		}
		// 当我们把Person中的默认的无参构造函数取消的时候，比如自己定义只定义一个有参数的构造函数之后，会出现错误
		// Exception in thread "main" java.lang.NullPointerException
		per.setName("Rollen");
		per.setId(213123);
		System.out.println(per);
		per1.getAge();

		hashcodetest testdemo = new hashcodetest();
		testdemo.setName("Rollen");
		testdemo.setId(213123);
		System.out.println(per);

		Getdemo4(testdemo);
		System.out.println(testdemo);

		
		
		Originator ori = new Originator();
		// 定义出备忘录管理员
		Caretaker caretaker = new Caretaker();
		// 初始化
		ori.setName("秦鹏明");
		ori.setAddrss("上海市");
		ori.setPhone("18801821692");
		System.out.println("===初始化状态===\n" + ori);
		// 创建一个备忘录
		caretaker.setMemento(ori.CreateMemento());
		// 修改状态值
		ori.setName("软件");
		ori.setAddrss("架构");
		ori.setPhone("优秀");
		System.out.println("\n===修改后状态===\n" + ori);
		// 恢复一个备忘录
		ori.RestoreMemento(caretaker.getMemento());
		System.out.println("\n===恢复后状态===\n" + ori);
		
		
		//多备份的备忘录
		Originator originator = new Originator();
		//定义出备忘录管理员
		MultiCaretaker caretaker1 = new MultiCaretaker();
		//创建两个备忘录
		caretaker1.setMemento("001",originator.CreateMemento());
		caretaker1.setMemento("002",originator.CreateMemento());
		//恢复一个指定标记的备忘录
		originator.RestoreMemento(caretaker1.getMemento("001"));

	}

	private static void Getdemo4(hashcodetest demo4) {

		demo4.setId(133);
		demo4.setName("fdsfsdf");
	}

}
