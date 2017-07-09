/**
 * 
 */
package pmiqn.com.Multithread;

/** 
* @author : pmqin
* @date   : 2016年7月27日 下午1:46:58 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class SynchronizedExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final example itExample = new SynchronizedExample().new example();

		new Thread(new Runnable() {
			public void run() {
				itExample.writer();
			}
		}).start();

//		ReentrantLock
//		new Thread(new Runnable() {
//			public void run() {
//				itExample.reader();
//			}
//		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					itExample.testSynchronized(i);
				}
			}
		}).start();

	}

	class example {
		int a = 0;
		boolean flag = false;

		public void testSynchronized(int i) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + "同步锁没有标记在方法上的时候就是非线程安全的,也就是可以被其他线程调用");
		}

		public synchronized void writer() { // 获取锁
			a = 1;
			flag = true;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reader();
		} // 释放锁

		public synchronized void reader() { // 获取锁
			if (flag) {
				int i = a;
				System.out.println(i);
				// ……
			} // 释放锁
			else {
				System.out.println("没有写");
			}
		}
	}

}
