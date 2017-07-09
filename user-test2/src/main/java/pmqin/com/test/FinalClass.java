/**
 * 
 */
package pmqin.com.test;
/** 
* @author : pmqin
* @date   : 2016年3月27日 下午4:02:01 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public  class FinalClass {

	public static void main(String[] args) {
		FinalClass item=new FinalClass();
		System.out.println(item.GetName());
	}
	static {
		System.out.println("静态代码块");
	}
	//final 可以不加
	public  int  GetName() {
		return 4;
	}
}
