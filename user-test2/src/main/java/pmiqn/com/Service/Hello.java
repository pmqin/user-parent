/**
 * 
 */
package pmiqn.com.Service;

import pmqin.com.IService.IHello;

/** 
* @author : pmqin
* @date   : 2016年4月5日 下午11:44:49 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Hello implements  IHello {

	@Override
	public void hello() {
		 System.out.println("我是Hello.");
	}

	@Override
	public Object hello2() {
		// TODO Auto-generated method stub
		return null;
	}
	     
}
