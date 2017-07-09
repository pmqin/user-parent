/**
 * 
 */
package pmqin.com.test;
/** 
* @author : pmqin
* @date   : 2016年8月7日 下午3:17:17 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class integertest { 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		
		Integer e=321;
		Integer f=321;
		Long g=3L;
		System.out.println(c==d);
		System.out.println(e==f);
		System.out.println(c==(a+b));
		System.out.println(c.equals(a+b));
		System.out.println(g==(a+b));
		System.out.println(g.equals(a+b));
	}

}
