/**
 * 
 */
package pmiqn.com.Multithread;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

import javax.net.ssl.SSLContext;

/** 
* @author : pmqin
* @date   : 2016年7月17日 下午6:04:58 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class CallableTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread2 myThread2 = new CallableTest().new MyThread2();
		FutureTask<Integer> futureTask = new FutureTask<>(myThread2);
		new Thread(futureTask, "线程名：有返回值的线程").start();
		try {
			System.out.println("子线程的返回值：" + futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Callable是線程同步的");
		
		ConcurrentHashMap<String,String> ss=new ConcurrentHashMap<String,String>();
		ss.get(1);
		ss.put("fdfds", "fsdfsd");
		HashMap<String, String> dd=new HashMap<String, String> ();
		
//		switch (dd)
//		{
//		   case "a":
//			   System.out.println("a");
//			   break;
//		   case "b":
//			   System.out.println("b");
//		}
		
		
		
		
	}

	class MyThread2 implements Callable<Integer> {

		public Integer call() throws Exception {
			System.out.println("当前线程名——" + Thread.currentThread().getName());
			int i = 0;
			for (; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println("循环变量i的值：" + i);
			}

			return i;
		}
	}

}
