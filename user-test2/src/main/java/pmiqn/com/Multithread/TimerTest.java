/**
 * 
 */
package pmiqn.com.Multithread;

import java.sql.Time;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;


/** 
* @author : pmqin
* @date   : 2016年7月26日 上午11:35:34 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Time(220);
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("1222312312");
			}
		}, 1000);
		
		int d=new Random().nextInt(9);//0 <= nextInt(n) < n
		System.out.println(new Time(122));
		
	}
	
	  public static int[] random(int length){
	        if (length <= 0) {
	            return new int[0];
	        }
	        List<Integer> list = new ArrayList<Integer>(length);
	        for (int i = 0; i < length; i++) {
	            list.add(i);
	        }
	        int[] array = new int[length];
	        for (int i = 0; i < length; i++) {
	            array[i] = list.remove(new Random().nextInt(length - i));
	        }
	        return array;
	    }

}
