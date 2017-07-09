/**
 * 
 */
package pmqin.com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
* @author : pmqin
* @date   : 2016年7月25日 下午5:41:30 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class StaticClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// StaticClass.Write();
		// StaticClass.Write();
		// System.out.println("b=" + StaticClass.Read());
		// System.out.println("总共有几个对象呢？"+StaticClass.list.size());
		// for (Iterator<StaticClass> iterator = list.iterator();
		// iterator.hasNext();) {
		// StaticClass staticClass = (StaticClass) iterator.next();
		// System.out.println(staticClass.b);
		//
		StaticClass dd = new StaticClass();
		System.out.println(dd);
		StaticClass dd2 = new StaticClass();
		System.out.println(dd2);

	}

	static int a = 0;
	public int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;
	static StaticClass obj ;//這個永遠只有一個 
	public static List<StaticClass> list = new ArrayList<>();

	static {
		System.out.println("静态构造函数StaticClass");
	}

	public StaticClass() {
		a++;
		b = a + 1;
		System.out.println("实例构造函数StaticClass");
		obj = this;//根據當前實例替換;
		// obj = new StaticClass();不能自我构造，不然死循环
	}

	public static String MyName = "";

	public static void SetName(String name) {
		MyName = name;
	}

	public static String GetName() {
		return MyName;
	}

	public static void Write() {

		StaticClass obj = new StaticClass();

		System.out.println(obj.obj);
		StaticClass obj2 = new StaticClass();
		System.out.println(obj2.obj);
		System.out.println(StaticClass.obj);
		list.add(obj);
	}

	public static int Read() {
		StaticClass obj2 = obj;
		return obj2.b;
	}

}
