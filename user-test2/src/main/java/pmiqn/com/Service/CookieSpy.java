/**
 * 
 */
package pmiqn.com.Service;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

/** 
* @author : pmqin
* @date   : 2016年6月5日 下午6:47:58 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class CookieSpy {

	private final static String TIME_FORMAT_NOW = "HH:mm:ss";

	private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(TIME_FORMAT_NOW);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			String strURL = "http://www.taobao.com";
			// CustomCookiePolicy policy=new CustomCookiePolicy();
			CookieManager manager = new CookieManager();

			manager.setCookiePolicy(new CookiePolicy() {

				@Override
				public boolean shouldAccept(URI uri, HttpCookie cookie) {
					// return uri.getHost().equals("baidu.com");
					System.out.println("shouldAcceptHost:=" + uri.getHost());
					return true;
				}
			});
			CookieHandler.setDefault(manager);
			URL url = new URL(strURL);
			URLConnection connection = url.openConnection();
			Object object = connection.getContent();

			List<HttpCookie> cookies = manager.getCookieStore().getCookies();

			for (Iterator iterator = cookies.iterator(); iterator.hasNext();) {
				HttpCookie httpCookie = (HttpCookie) iterator.next();
				System.out.println("Name:" + httpCookie.getName());
				System.out.println("Domain:" + httpCookie.getDomain());

				long age = httpCookie.getMaxAge();
				if (age == -1) {
					System.out.println("Browser closes");
				} else {
					System.out.printf("This cookie will expire in %s" + "Seconds%n", SIMPLE_DATE_FORMAT.format(age));
				}

				System.out.println("Secured:" + ((Boolean) httpCookie.getSecure()).toString());
				System.out.println("Value:" + httpCookie.getValue());
				System.out.println();

			}

		} catch (Exception exception) {
		} finally {
			// TODO: handle finally clause
		}
	}
	// class CustomCookiePolicy implements CookiePolicy
	// {
	//
	// @Override
	// public boolean shouldAccept(URI uri, HttpCookie cookie) {
	// return true;
	// }
	//
	// }

}
