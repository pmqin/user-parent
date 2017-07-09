/**
 * 
 */
package pmqin.com.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pmqin.com.test.hashcodetest;

/** 
* @author : pmqin
* @date   : 2016年8月20日 下午7:42:46 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class WeightedRoundRobin {

	static int robin = 0;

	/// <summary>
	/// 锁对象
	/// </summary>
	private static final Object locker = new Object();

	/// <summary>
	/// 服务器权重列表
	/// </summary>
	private static List<Integer> server = new ArrayList<>();

	/// <summary>
	/// 当前索引
	/// </summary>
	private static int currentIndex;

	/// <summary>
	/// 当前权重
	/// </summary>
	private static int currentWeight;

	private static int maxWeight;

	/// <summary>
	/// 最大公约数
	/// </summary>
	private static int gcd;

	static {
		currentIndex = -1;
		currentWeight = 0;

		// 获取服务器权重列表,从配置文件
		server = GetWeightList();
		maxWeight = getMaxWeight(server);
		gcd = GetMaxGCD(server);
	}

	public static void main(String[] args) {
//		WeightedRoundRobin inner = new WeightedRoundRobin();
//		List<test> serviceIps = new ArrayList<>();
//		serviceIps.add(inner.new test(1, "192.168.0.1"));
//		serviceIps.add(inner.new test(2, "192.168.0.2"));
//		serviceIps.add(inner.new test(3, "192.168.0.3"));
//		serviceIps.add(inner.new test(4, "192.168.0.4"));
//		serviceIps.add(inner.new test(5, "192.168.0.5"));
//		int count = serviceIps.size();
//
//		for (int i = 0; i < 19; i++) {
//
//			int index = robin % count;
//			if (index == 0 && robin != 0) {// 防止访问量过大
//				robin = 0;
//			}
//			robin += 1;
//			String getip = serviceIps.get(index).getIp();
//			System.out.println("第" + (i + 1) + "个用户访问:" + getip);
//		}

		// try {
		// ExecutorService pool = Executors.newFixedThreadPool(1);
		//
		// for (int i = 0; i < 100; i++) {
		// Runnable run = new Runnable() {
		// public void run() {
		// System.out.print(WeightedRoundRobin.next() + ",");
		// }
		// };
		//
		// pool.execute(run);
		// }
		// // 关闭启动线程
		// pool.shutdown();
		// // 等待子线程结束，再继续执行下面的代码
		// pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		// System.out.println("all thread complete");
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		
		

	}

	private static List<Integer> GetWeightList() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(4);
		list.add(1);
		list.add(7);

		return list;
	}

	public static Integer next() {

		while (true) {
			currentIndex = (currentIndex + 1) % server.size();
			// System.out.println("number=" + number);
			// System.out.println("cw=" + cw);
			if (currentIndex == 0) {
				currentWeight = currentWeight - gcd;// cw比较因子，从最大权重开始，以最大公约数为步长递减
				if (currentWeight <= 0) {//
					currentWeight = maxWeight;
					if (currentWeight == 0)
						return null;
				}
			}
			if (server.get(currentIndex) >= currentWeight)
				return currentIndex;
		}

	}

	public static int getMaxWeight(List<Integer> ary) {
		int max = 0;
		for (int i = 0; i < ary.size(); i++) {
			if (max < ary.get(i)) {
				max = ary.get(i);
			}
		}
		return max;
	}

	/// <summary>
	/// 获取最大公约数
	/// </summary>
	/// <param name="list">要查找的int集合</param>
	/// <returns>返回集合中所有数的最大公约数</returns>
	private static int GetMaxGCD(List<Integer> list) {
		// Collections.sort(list);
		//
		int iMinWeight = server.get(0);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < iMinWeight) {
				iMinWeight = list.get(i);
			}
		}
		while (iMinWeight >= 1) {
			boolean isCommon = true;
			for (int i = 0; i < server.size(); i++) {
				if (server.get(i) % iMinWeight != 0) {
					isCommon = false;
					break;
				}
			}
			if (isCommon) {
				break;
			}
			iMinWeight--;
		}
		return iMinWeight;
	}

	public class test {

		private int id;
		private String ip;

		/**
		 * @param i
		 * @param string
		 */
		public test(int id, String ip) {
			this.id = id;
			this.ip = ip;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}
	}

}
