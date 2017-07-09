/**
 * 
 */
package pmqin.com.test;

import java.util.List;

/** 
* @author : pmqin
* @date   : 2016年8月6日 下午5:58:07 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Clinit {

	/**
	 * @param args
	 *            初始化阶段是执行类构造器<clinit>()方法的过程
	 *            <clinit>（）方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块中的语句合并产生的，
	 *            编译器收集的顺序是由语句在源文件中出现的顺序所决定的，
	 *            静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句中可以赋值，但是不能访问。
	 */
	public static void main(String[] args) {
		System.out.println(BaseA.b);
		System.out.println(BaseCase.a);
	}

	public static class BaseCase {
		//public  static int a = 1; //2
		static {
			a = 2;
			 //System.out.println("前面的静态语句中可以赋值，但是不能访问"+a);
		}

		public static  int a = 1; // 1

	}

	public static class BaseA extends BaseCase {
		public static int b = a;
	}

//	public void getname(List<Integer> a) {
//
//	}

	public void getname(List<String> a) {

	}

}
