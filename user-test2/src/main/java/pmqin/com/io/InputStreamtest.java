package pmqin.com.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamtest {

	public static void main(String[] args) {
		int count = 0; // 统计文件字节长度
		File file = new File("./create.txt");
		InputStream streamReader = null; // 文件输入流
		try {
			streamReader = new FileInputStream(file);
			/*
			 * 1.new File()里面的文件地址也可以写成D:\\David\\Java\\java
			 * 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
			 * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
			 */
			byte[] buffer = new byte[streamReader.available()]; // new
																// byte[512];
																// //一次取出的字节数大小,缓冲区大小
																// ,指定大小取出

			// read()方法每次只能读取一个字节，所以也只能读取由ASCII码范围内的一些字符。这些字符主要用于显示现代英语和其他西欧语言。而对于汉字等unicode中的字符则不能正常读取。只能以乱码的形式显示。

			// while(streamReader.read()!=-1) { //读取文件字节，并递增指针到下一个字节
			// System.out.println("---正在读的是第： "+count+" 字节");
			// count++;
			// }

			// 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 buffer
			// 中。以整数形式返回实际读取的字节数。在输入数据可用、检测到文件末尾或者抛出异常前，此方法一直阻塞
			// 在read(byte[]
			// b)中则得到了解决，就拿汉字来举例，一个汉字占有两个字节，则可以把参数数组b定义为大小为2的数组即可正常读取汉字了。当然b也可以定义为更大，比如如果b=new
			// byte[4]的话，则每次可以读取两个汉字字符了，但是需要注意的是，如果此处定义b
			// 的大小为3或7等奇数，则对于全是汉字的一篇文档则不能全部正常读写了。
			int numberRead = 0;
			while ((numberRead = streamReader.read(buffer)) != -1) {// 完整的一次性读
				System.out.println("---正在读的是第： " + numberRead + " 字节");
				// stringBuilder.append(new String(buffer, 0, readBytes));
				System.out.println(new String(buffer,"gbk"));
				count += numberRead;
			}
			System.out.println("---长度是： " + count + " 字节");

			// 用“.”把file的文件名分隔开
			String[] s = file.getName().split("\\.");// 因为"."在正则表达式中有特殊的含义，使用的时候必须进行转义。
			String copyFName = s[0] + "_" + "copy" + System.currentTimeMillis() + "." + s[1];
			File file1 = new File(copyFName);
			FileOutputStream fos = new FileOutputStream(file1, true);
			fos.write(buffer);// 把刚刚从file 文件读出的内容写入副本file1

		} catch (final IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				streamReader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

	}

	/**
	 * 通过文件名获取内容【解决中文乱码】
	 * @param fileName
	 * @return
	 */
	public static String getFileContent(String fileName) {
		StringBuffer stringBuffer = new StringBuffer();
		File file = new File(fileName);
		InputStream inputStream = null; // 文件输入流
		try {
			inputStream = new FileInputStream(file);

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK"); // 最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"//适配器模式 
			BufferedReader br = new BufferedReader(inputStreamReader);//装饰者模式
			//DataInputStream dis = new DataInputStream(inputStream);//装饰者模式
			//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf8")); 
			String line;
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
			}
			br.close();
			inputStreamReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringBuffer.toString();

	}

}
