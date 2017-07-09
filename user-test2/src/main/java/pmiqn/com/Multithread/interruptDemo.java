/**
 * 
 */
package pmiqn.com.Multithread;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.SSLException;

/** 
* @author : pmqin
* @date   : 2016年7月26日 下午9:43:00 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class interruptDemo {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		// Ticket t = new testDemo().new Ticket();
		// Thread t1 = new Thread(t, "窗口一");
		// Thread t2 = new Thread(t, "窗口二");
		// Thread t3 = new Thread(t, "窗口三");
		// Thread t4 = new Thread(t, "窗口四");
		// t1.start();
		// t2.start();
		// t3.start();
		// t4.start();

		Thread interrupt = new Thread(new interruptDemo().new ThreadInterrupt());
		System.out.println("50s中断");
		interrupt.start();
		Thread.sleep(1000);
		//触发条件设置中断
		interrupt.interrupt();
		System.out.println(interrupt.isInterrupted());
		System.out.println(interrupt.interrupted());
		// interrupt.interrupt();//线程终止的方式2, 阻塞线程的采用这个方式，其实就是中断sleep
		// 、wait、Condition、定时锁的线程，并不会中断此线程
		// interrupt.join();
		// （1）interrupt：中断阻塞的线程，其实就是中断sleep、join wait、Condition、定时锁的线程 (ServerSocket.accept()和DatagramSocket.receive())，并不会中断此线程catch下面的逻辑
		// （2）isInterrupted：判断线程是否中止采用isInterrupted
		// （3）interrupted：返回线程的上次的中断状态，并清除中断状态
		// thread3.holdsLock(thread3);
		System.out.println("主线程已经退出");
	}

	class Ticket implements Runnable {
		public volatile boolean exit = false;// 线程终止的方式1 变量控制
		private int ticket = 10;

		public void saleTicket() {
			if (ticket > 0)
				System.out.println(Thread.currentThread().getName() + "卖出了" + ticket--);
			else {
				exit = true;
				System.out.println(Thread.currentThread().getName() + "没有票了，结束线程");

			}

		}

		public void run() {
			while (!exit) {
				saleTicket();
			}
		}
	}

	class ThreadInterrupt implements Runnable {

		@Override
		public void run() {
			try {
				System.out.println("等待的");
				while (true && (!Thread.currentThread().isInterrupted())) {
					System.out.print('H' + 'a');//字符值会通过一个叫做基础类型拓宽的操作来转换成整型值。然后再将值相加得到169
					Thread.sleep(10000);
					for (int i = 0; i < 10; i++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("......." + i + 1);
					}
				}
			} catch (InterruptedException e) {
				// 执行这个方法会抛出异常，就务必在异常中继续关闭线程
				Thread.currentThread().interrupt();
				System.out.println(e.getMessage() + "---线程InterruptedException");
			}
			// 如果这个地方还有逻辑是不会完全终止的

		}

	}

}
