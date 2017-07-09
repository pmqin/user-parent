/**
 * 
 */
package pmqin.com.jvm;

import java.util.ArrayList;
import java.util.List;

/** 
* @author : pmqin
* @date   : 2016年8月5日 下午10:06:13 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class fillhead {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		fillHeap(600);
	}
	public static void fillHeap(int num) throws InterruptedException {
		List<oomobject> list=new ArrayList<oomobject>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(1000);
			list.add(new oomobject());
			System.out.println("fillHeap"+i);
		}
		System.gc();
		
	}
	
	static class oomobject{
		public byte[] aa=new byte[64*1024];
	}

}
