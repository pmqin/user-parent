package pmqin.com.io;

import java.io.BufferedOutputStream;

import java.io.DataOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamtest {

	public static void main(String[] args) throws IOException {
		// FileOutputStream fos=new FileOutputStream("./11.txt");

		// BufferedWriter bw=new BufferedWriter(fos);
		// bw.write("你好");
		// bw.newline();
		// bw.write("java");
		// bw.newline();
		String s1 = "How are you?";
		String s2 = "Fine.Thanks!";
		File file = new File("./demo33.txt");
		FileOutputStream fos1 = new FileOutputStream(file, false);// true表示如果文件已经存在，执行程序一次便往文件追加一次内容，否则会每一次的执行结果会覆盖文件上一次执行结果
		//BufferedOutputStream bos1 = new BufferedOutputStream(fos1);// 把fos1封装成具有缓冲功能的文件输出流
		// bos.write(s1.getBytes());
		fos1.write(s1.getBytes());// 把字符串s1以字节流形式写入demo1.txt文件中
		// fos2.write(s2.getBytes());//把字符串s2以字节形式流写入demo2.txt文件中
		fos1.write(s2.getBytes());

		FileOutputStream fos2 = new FileOutputStream("./demo2.txt", false);
		//DataOutputStream bos2 = new DataOutputStream(fos2);// DataOutputStream提供了写入任意对象的能力
		//fos2.writeBytes(s1 + " gggggg  " + s2);
		fos2.write(s1.getBytes());
		

	}

}
