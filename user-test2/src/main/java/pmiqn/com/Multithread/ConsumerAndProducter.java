/**
 * 
 */
package pmiqn.com.Multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
* @author : pmqin
* @date   : 2016年5月18日 下午1:57:12 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ConsumerAndProducter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Lock lock = new ReentrantLock();
		 Consumer consumer = new ConsumerAndProducter().new Consumer(lock);
         Producer producer = new ConsumerAndProducter().new Producer(lock);
         
          new Thread(consumer).start();
          new Thread( producer).start();
	}
	
	class Consumer implements Runnable {
		 
	     private Lock lock;
	     public Consumer(Lock lock) {
	            this. lock = lock;
	     }
	     @Override
	     public void run() {
	            // TODO Auto-generated method stub
	            int count = 10;
	            while( count > 0 ) {
	                 try {
	                      lock.lock();
	                     count --;
	                     System. out.print( "B");
	                } finally {
	                      lock.unlock(); //主动释放锁
	                      try {
	                           Thread. sleep(91L);
	                     } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                           e.printStackTrace();
	                     }
	                }
	           }
	 
	     }
	 
	}
	
	
	 class Producer implements Runnable{
		 
	     private Lock lock;
	     public Producer(Lock lock) {
	            this. lock = lock;
	     }
	     @Override
	     public void run() {
	            // TODO Auto-generated method stub
	            int count = 10;
	            while (count > 0) {
	                 try {
	                      lock.lock();
	                     count --;
	                     System. out.print( "A");
	                } finally {
	                      lock.unlock();
	                      try {
	                           Thread. sleep(90L);
	                     } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                           e.printStackTrace();
	                     }
	                }
	           }
	     }
	}
	

	

}

