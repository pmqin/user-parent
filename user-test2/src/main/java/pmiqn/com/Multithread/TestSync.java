/**
 * 
 */
package pmiqn.com.Multithread;


/** 
* @author : pmqin
* @date   : 2016年7月26日 下午2:58:56 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestSync {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TestSync sync = new TestSync();
		final syncTest oop = sync.new syncTest();
		// 子線程的10次,母線程20次,然後子線程10次,母線程20 ,就这样连续重复20次
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					oop.sub(i + 1);
				}

			}
		}).start();
		// 主线程运行
		for (int i = 0; i < 20; i++) {
			oop.main(i + 1);
		}

	}

	class syncTest {
		boolean falg;// 控制先后顺序

		public synchronized void sub(int j) {

			while (falg) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			for (int i = 0; i < 10; i++) {
				System.out.println("sub线程执行" + i + ",第" + j + "次循环");
			}
			falg = true;// 改变状态
			this.notify();// 通知主线程执行,调用notify()后，并不会立即释放锁，而是继续执行当前代码，直到synchronized中的代码全部执行完毕，
			//才会释放对象锁。JVM则会在等待的线程中调度一个线程去获得对象锁，执行代码。需要注意的是，wait()和notify()必须在synchronized代码块中调用
			System.out.println("sub this.notify" + j + "次循环");
		}

		public synchronized void main(int j) {

			while (!falg) {
				System.out.println("有没有循环falg,第" + j + "次循环");
				try {
					//Thread.sleep(10000);//线程调用此方法后，会休眠一段时间，休眠期间，会暂时释放cpu，但并不释放对象锁。
					this.wait();
					System.out.println("有没有循环wait,第" + j + "次循环");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("有没有循环,第" + j + "次循环");

			}
			for (int i = 0; i < 20; i++) {
				System.out.println("main线程执行" + i + ",第" + j + "次循环");
			}
			falg = false;// 改变状态
			this.notify();// 通知子线程执行
			System.out.println("main this.notify" + j + "次循环");
		}

	}

}
