/**
 * 
 */
package pmiqn.com.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

/** 
* @author : pmqin
* @date   : 2016年6月5日 下午5:42:00 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class SocketHello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			 //Socket socketobject=new Socket("www.baidu.com",80);
			 Socket socketobject=new Socket("localhost",10001);
			 OutputStream outputStream=socketobject.getOutputStream();
			 String string="GET / HTTP/1.0\n\n";
			 outputStream.write(string.getBytes());
			 
			 InputStream inputStream=socketobject.getInputStream();
			 Scanner reader=new Scanner(inputStream);
			 
			 while (reader.hasNextLine()) {
				String line= reader.nextLine();
				System.out.println(line);
			}
			 
			 socketobject.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
