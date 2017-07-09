/**
 * 
 */
package pmiqn.com.Multithread;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/** 
* @author : pmqin
* @date   : 2016年7月31日 下午7:13:07 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class TestShutDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			testShutDown(100);
			testShutDowNow(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testShutDown(int startNo) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executorService.execute(getTask(i + startNo));
		}
		executorService.shutdown();//直到添加到线程池中的任务都已经处理完成
		executorService.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("shutDown->all thread shutdown");
	}
	
	 public static void testShutDowNow(int startNo) throws InterruptedException {
	        ExecutorService executorService = Executors.newFixedThreadPool(2);
	        for (int i = 0; i < 5; i++) {
	            executorService.execute(getTask(i + startNo));
	        }
	        //并试图停止所有正在执行的线程,它会返回那些未执行的任务列表
	        List<Runnable>  dd=executorService.shutdownNow();
	        executorService.awaitTermination(1, TimeUnit.DAYS);
	        System.out.println("shutdownNow还有几个没有执行？"+dd.size());
	        System.out.println("shutdownNow->all thread shutdown");
	    }
	 //局部内部类实现
	public static Runnable getTask(int threadNo) {
        final Random rand = new Random();
        final int no = threadNo;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() +","+no + "-->" + rand.nextInt(10));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("thread " + no + " has error" + e);
                }
            }
        };
        return task;
    }

}
