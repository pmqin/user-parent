/**
 * 
 */
package pmiqn.com.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Observable;
import java.util.Scanner;


/** 
* @author : pmqin
* @date   : 2016年6月9日 下午10:21:38 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class EchoServer {

	private static ServerSocket server = null;

	public static void main(String[] args)  {
		
		System.out.println(args[1]);
//		Monitor2 t1=new EchoServer().new Monitor2();
//		Thread aThread=new Thread(t1);
//		aThread.setDaemon(true);
//		aThread.start();
		byte buffer[]=new byte[512];
		new Thread(new Monitor2()).start();
		
		try {
			server=new ServerSocket(10000);
			System.out.println("Server Started");
			while (true) {
				Socket socket=server.accept();//阻塞 直到有客户端来请求
				InputStream reader=socket.getInputStream();
				 Scanner reader11=new Scanner(reader);
				 
				 while (reader11.hasNextLine()) {
					String line= reader11.nextLine();
					System.out.println("客户端的请求"+line);
				}
				reader.read(buffer);
				OutputStream writer=socket.getOutputStream();
				writer.write(buffer);
				socket.close();
				
			}
			
			
		}
		catch (SocketException exception)
		{
			System.out.println("Server is Downed");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	private static void ShutDownServer() {
		try {
			System.out.println("服务器停止运行ShutDownServer");
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
    static	class Monitor2 implements Runnable {
		
		@Override
		public void run() {
			try {
				int a = 0;
				while (System.in.read()!='\n') {
				//while (true) {
					a++;
					Thread.sleep(1000);
					System.out.println("Monitor" + a);
					if (a>2000) {
						System.out.println("服务器停止运行" + a);
						break;
					}
				}
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ShutDownServer();
		}
	}


}
