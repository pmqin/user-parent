/**
 * 
 */
package com.cn.pmqin.Model;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午6:05:11 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Customer {

	private Person person;

	public Customer(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + "]";
	}
}
