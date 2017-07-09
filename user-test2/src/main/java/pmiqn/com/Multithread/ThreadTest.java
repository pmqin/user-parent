/**
 * 
 */
package pmiqn.com.Multithread;

/** 
* @author : pmqin
* @date   : 2016年7月17日 下午5:50:28 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//http://blog.csdn.net/aboy123/article/details/38307539/
		ThreadTest maintest = new ThreadTest();
		//接口的实现
		MyThread1 myThread = maintest.new MyThread1(8);
		new Thread(myThread).start();
		new Thread(myThread).start();
		new Thread(myThread).start();

		// new ThreadTest().new MyThread3().start();
		//继承的实现多线程
		MyThread3 thread3 = maintest.new MyThread3("qinpm");
		thread3.start();
		

		//匿名继承的实现 多线程
		new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "extends");
			}
		}.start();

//		/JKD8
//		new Thread(() -> {
//			
//			      for (int i=0; i< 9; i++) {
//			
//			         System.out.println(String.format("Message #%d from inside the thread!", i));
//			
//			      }
//			
//			  }).start();

		
		

		//thread3.suspend();

	}
	

	class MyThread1 implements Runnable {
		private int ticket = 5;// 可能会造成线程的不安全

		public MyThread1(int d) {
			this.ticket = d;
		}

		public void run() {
			for (int i = 0; i < 10; i++) {
				if (ticket > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "ticket = " + ticket--);
				}
			}
		}
	}

	class MyThread2 implements Runnable {

		public void run() {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "Runnable");

		}
	}

	class MyThread3 extends Thread {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "extends" + name);
		}

		private String name;

		public MyThread3(String strName) {
			this.name = strName;
		}

	}

}
