/**
 * 
 */
package pmiqn.com.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import pmiqn.com.Service.EchoServer.Monitor2;

/** 
* @author : pmqin
* @date   : 2016年6月10日 下午3:09:04 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class EchoMultiServer {

	private static ServerSocket server = null;
	private static ExecutorService threadpool;

	public static void main(String[] args) {

		threadpool = Executors.newCachedThreadPool();
		threadpool.submit(new Monitor2());
		try {
			server = new ServerSocket(10001);
			System.out.println("服务监听10001端口");
			while (true) {
				Socket socketobject = server.accept();
				System.out.println("线程创建完成");
				threadpool.submit(new EchoServer(socketobject));
			}

		} catch (IOException e) {
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
		System.exit(0);

	}

	static class Monitor2 implements Runnable {

		@Override
		public void run() {
			try {
				int a = 0;
				while (System.in.read() != '\n') {
										a++;
					Thread.sleep(1000);
					System.out.println("Monitor" + a);
					if (a > 2000) {
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

	static class EchoServer implements Runnable {

		public EchoServer(Socket socketobject) {
			this.socket = socketobject;
		}

		private byte buffer[] = new byte[512];
		private Socket socket = null;

		@Override
		public void run() {
			try {
				try {
					InputStream reader = socket.getInputStream();
					reader.read(buffer);
					OutputStream writer = socket.getOutputStream();
					writer.write(buffer);
				} finally {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
