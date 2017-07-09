package pmqin.com.io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileRW {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer();
		char ch;
		try {
			while ((ch = (char) System.in.read()) != '\n') {
				buf.append(ch);
			}
			// 读写方式可以为"r" or "rw"
			RandomAccessFile myFileStream = new RandomAccessFile("./UserInput.txt", "rw");
			myFileStream.seek(myFileStream.length());
			myFileStream.writeBytes(buf.toString());
			// 将用户从键盘输入的内容添加到文件的尾部
			myFileStream.close();
		} catch (IOException e) {
		}
	}

}
