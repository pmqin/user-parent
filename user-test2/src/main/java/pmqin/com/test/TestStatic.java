/**
 * 
 */
package pmqin.com.test;
/** 
* @author : pmqin
* @date   : 2016年6月18日 下午9:17:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestStatic {
    
	static 
	{
		System.out.println("TestStatic静态代码块");
	}
	public TestStatic()
	{
		System.out.println("TestStatic实例构造函数");
	}
	public void Print(){
        System.out.println("Static");
    }
}
