package pmiqn.com.Multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadCommunicationTest3 {

	 private final Semaphore semap = new Semaphore(1);//创建一个只有1个许可的信号量，保证两个线程间每一时刻只有一个在工作  
	 private static char currentThread = 'A';  
	public static void main(String[] args) {
		
		   ThreadCommunicationTest3 test = new ThreadCommunicationTest3();  
		  
	        ExecutorService service = Executors.newCachedThreadPool();  
	  
	        service.execute(test.new RunnableA());  
	        service.execute(test.new RunnableB());  
	  
	        service.shutdown();  //异步的
	}
	
	private class RunnableA implements Runnable {  
        public void run() {  
            for (int i = 1; i <= 52; i++) {  
                try {  
                    semap.acquire();  
                    while (currentThread != 'A') {  
                        semap.release();  
                    }  
                    System.out.println(i);  
                    if (i % 2 == 0) {  
                        currentThread = 'B';  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                } finally {  
                    semap.release();  
                }  
            }  
        }  
    } 
	
	private class RunnableB implements Runnable {  
        public void run() {  
            for (char c = 'A'; c <= 'Z'; c++) {  
                try {  
                    semap.acquire();  
                    System.out.println("semap.acquire()");
                    while (currentThread != 'B') {  
                        semap.release();  
                    }  
                    System.out.println(c);  
                    currentThread = 'A';  
                } catch (Exception e) {  
                    e.printStackTrace();  
                } finally {  
                    semap.release();  
                }  
            }  
        }  
  
    }  

}
