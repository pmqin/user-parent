/**
 * 
 */
package pmiqn.com.Service;

import java.net.*;

/** 
* @author : pmqin
* @date   : 2016年6月10日 下午4:45:21 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class DNSLookup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InetAddress[] inetHost=null;
		
		System.out.println("baidu监听开始");
		try {
			inetHost=InetAddress.getAllByName("www.baidu.com");
			for (InetAddress address: inetHost) {
				System.out.println(address);
			}
			System.out.println("qq监听开始");
			inetHost=InetAddress.getAllByName("www.qq.com");
			for (InetAddress address: inetHost) {
				System.out.println(address);
			}
			System.out.println("getLocalHost监听开始");
			System.out.println(InetAddress.getLocalHost().toString());
			
			System.out.println(InetAddress.getByName("www.baidu.com").toString());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
