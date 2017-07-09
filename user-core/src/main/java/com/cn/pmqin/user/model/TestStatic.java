/**
 * 
 */
package com.cn.pmqin.user.model;

/** 
* @author : pmqin
* @date   : 2016年2月29日 下午12:42:17 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestStatic {
	static {
		System.out.println("基类 Static 静态语句块");
	}

	public TestStatic() {
		System.out.println("基类  默认无参构造器");
	}

	{
		System.out.println("基类 非静态语句块");
	}

	public static void Iint() {
		System.out.println("基类 Static Iint");
	}
}
