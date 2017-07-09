/**
 * 
 */
package pmqin.com.test;
/** 
* @author : pmqin
* @date   : 2016年4月24日 下午11:26:20 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassLoader loader= ClassLoaderTest.class.getClassLoader();
		while (loader!=null) {
			
			System.out.println(loader.getClass().getName());
			loader=loader.getParent();
			
		}
		System.out.println(loader);
		
		
		
	}

}
