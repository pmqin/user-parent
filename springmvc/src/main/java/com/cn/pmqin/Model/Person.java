/**
 * 
 */
package com.cn.pmqin.Model;
/** 
* @author : pmqin
* @date   : 2016年3月11日 下午6:05:36 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Person {
	    private String name;
	    private String address;
	    private int age;
	    
	    
	    public Person()
	    {
	    	System.out.println("当scope＝singleton，即默认情况，会在容器初始化时实例化");
	    }

		public Person(String name, String address, int age) {
			super();
			this.name = name;
			this.address = address;
			this.age = age;
		}
		public void init(){  
	        System.out.println(" Person init beans!"); 
		}
		public void destroy(){  
	        System.out.println("Person connection destroy");  
	    }  
  

		public String getName() {
			return name;
		}



		public String getAddress() {
			return address;
		}



		public int getAge() {
			return age;
		}



		public void setName(String name) {
			this.name = name;
		}

		

		public void setAddress(String address) {
			this.address = address;
		}

		

		public void setAge(int age) {
			this.age = age;
		}

		

	    //getter and setter methods…此处省略
	    @Override
		public String toString() {
			return "Person [name=" + name + ", address=" + address + ", age=" + age + "]";
		}
	    
}
