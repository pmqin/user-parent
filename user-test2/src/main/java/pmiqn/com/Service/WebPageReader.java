/**
 * 
 */
package pmiqn.com.Service;

import java.io.InputStream;
import java.net.*;
import java.util.Scanner;

import org.apache.xerces.impl.io.UTF8Reader;

/** 
* @author : pmqin
* @date   : 2016年6月5日 下午6:09:12 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class WebPageReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			String strURL="http://www.cnblogs.com/PurpleDream/p/5559352.html";
			URL  url=new URL(strURL);
			URLConnection connection=url.openConnection();
			
			InputStream inputStream=connection.getInputStream();
			
			Scanner reader=new Scanner(inputStream);
			while (reader.hasNextLine()) {
				String string=reader.nextLine();
				System.out.println(string);
			}
			reader.close();
		} catch(Exception exception){}
		finally {
			// TODO: handle finally clause
		}
	}

}
