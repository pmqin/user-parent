/**
 * 
 */
package pmqin.com.test;

import java.io.IOException;

//public abstract class abstractClass extends Filetest {
public abstract class abstractClass implements Itest {
	// 一般而言 抽象方法，一定在抽象类中，有一个特殊的是在接口中，因为接口隐式的方法修饰符 是public abstract
	static {
		System.out.println("JVM会执行该类的静态代码段");
	}

	public abstract int getAge();

	public void GetName() {
		// Filetest.createArrayList(elements) 抽象类可以继承实体类
		System.out.println("abstractClass" + getAge()+AdressName());

	}

//	protected void setup(abstractClass context) throws IOException, InterruptedException {
//		System.out.println("abstractClass");
//	}

}
