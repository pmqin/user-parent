package pmqin.com.Collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrenttest {

	static ConcurrentHashMap<Long, String> conMap = new ConcurrentHashMap<Long, String>();

	public static void main(String[] args) throws InterruptedException {
		conMap.get(1);
		conMap.size();
		for (long i = 0; i < 5; i++) {
			conMap.put(i, i + "");
			conMap.clear();//因为没有全局的锁，在清除完一个segments之后，正在清理下一个segments的时候，已经清理segments可能又被加入了数据，因此clear返回的时候，ConcurrentHashMap中是可能存在数据的。因此，clear方法是弱一致的
		}

		Thread thread = new Thread(new Runnable() {
			public void run() {
				conMap.put(100l, "100");
				System.out.println("ADD:" + 100);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for (Iterator<Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
					Entry<Long, String> entry = iterator.next();
					System.out.println(entry.getKey() + " - " + entry.getValue());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		thread2.start();

		Thread.sleep(3000);

	}

}
