package pmqin.com.io;

import java.io.*;

public class PipedStream {

	public static void main(String[] args) throws IOException {
		// 构造读写的管道流对象
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		// 实现关联
		pos.connect(pis);

		//构造两个线程，并且启动。
		PipedStream pipedStream=new PipedStream();
		pipedStream.new Sender(pos,"./create.txt").start();
		pipedStream.new Receiver(pis,"./createPipedStream.txt").start();
		
	}

	// 线程发送 获取数据，写入到PipedOutputStream
	class Sender extends Thread {
		PipedOutputStream pos;
		File file;

		// 构造方法
		Sender(PipedOutputStream pos, String fileName) {
			this.pos = pos;
			file = new File(fileName);
		}

		// 线程运行方法
		public void run() {
			try {
				// 读文件内容
				FileInputStream fs = new FileInputStream(file);
				int data;
				while ((data = fs.read()) != -1) {
					// 写入管道始端
					pos.write(data);
				}
				pos.close();
			} catch (IOException e) {
				System.out.println("Sender Error" + e);
			}
		}
	}

	// 线程接收  获取PipedOutputStream 写入到本地
	class Receiver extends Thread {
		PipedInputStream pis;
		File file;

		// 构造方法
		Receiver(PipedInputStream pis, String fileName) {
			this.pis = pis;
			file = new File(fileName);
		}

		// 线程运行
		public void run() {
			try {
				// 写文件流对象
				FileOutputStream fs = new FileOutputStream(file);
				int data;
				// 从管道末端读
				while ((data = pis.read()) != -1) {
					// 写入本地文件
					fs.write(data);
				}
				pis.close();
			} catch (IOException e) {
				System.out.println("Receiver Error" + e);
			}
		}
	}
}
