/**
 * 
 */
package com.cn.pmqin.Model;
/** 
* @author : pmqin
* @date   : 2016年3月11日 下午1:44:23 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class HelloWorld {

	//用来验证是否是单件
	private  int couter = 0;
	
	public HelloWorld ()
	{
		couter++;
	}
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
        this.name = name;
    }
 
    public void printHello() {
        System.out.println("第一个Spring 3 : Hello ! " + name);
    }
    
    public int getCouter() {
		return couter;
	}

	public void setCouter(int couter) {
		this.couter = couter;
	}
}
