/**
 * 
 */
package pmqin.com.Generic;
/** 
* @author : pmqin
* @date   : 2016年6月12日 下午8:12:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class test extends ConcreteItestkjh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ConcreteItestkjh dd=new test();
	    System.out.println(dd.getAddress());
	}

	/* (non-Javadoc)
	 * @see pmqin.com.Generic.Itestkjh#setName()
	 */
	@Override
	public void setName() {
		System.out.println("测试一下setName");
	}

	/* (non-Javadoc)
	 * @see pmqin.com.Generic.Itestkjh#getAddress()
	 */
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return "getAddress";
		/** 
		* @parameter  
		*/
	}

}
