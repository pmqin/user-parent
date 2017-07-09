/**
 * 
 */
package pmiqn.com.Multithread;
/** 
* @author : pmqin
* @date   : 2016年7月27日 下午2:57:38 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ConsumerProduce {

	public static final Object obj = new Object();
	public static void main(String[] args) {
		
		 new Thread( new ConsumerProduce().new Produce()).start();
         new Thread( new ConsumerProduce().new Consumer()).start();
	}
	
	class Consumer implements Runnable {
		 
	     @Override
	     public  void run() {
	            // TODO Auto-generated method stub
	            int count = 10;
	            while(count > 0) {
	                 synchronized (ConsumerProduce.obj) {
	                     
	                     System. out.print( "B");
	                     count --;
	                     ConsumerProduce.obj.notify(); // 主动释放对象锁
	                     
	                      try {
	                    	  ConsumerProduce.obj.wait();
	                           
	                     } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                           e.printStackTrace();
	                     }
	                }
	                
	           }
	     }
	}

	class Produce implements Runnable {
		 
	     @Override
	     public void run() {
	            // TODO Auto-generated method stub
	            int count = 10;
	            while(count > 0) {
	                 synchronized (ConsumerProduce.obj) {
	                     
	                      //System.out.print("count = " + count);
	                     System. out.print("A");
	                     count --;
	                     ConsumerProduce.obj.notify();
	                     
	                      try {
	                    	  ConsumerProduce.obj.wait();
	                     } catch (InterruptedException e) {
	                            // TODO Auto-generated catch block
	                           e.printStackTrace();
	                     }
	                }
	                
	           }
	 
	     }
	 
	}
}
