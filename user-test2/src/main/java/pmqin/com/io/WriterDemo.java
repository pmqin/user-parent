package pmqin.com.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//賦值程序 file1.txt->file1copy.txt
public class WriterDemo {

	public static void main(String[] args) throws IOException {
		// String source = "learn how to write to file";
		// FileWriter f1 = new FileWriter("file1.txt");
		// f1.write(source);
		// f1.close();
		
		FileReader fr = null;
		FileWriter fw = null;
		try {
			long time = System.currentTimeMillis();
			fr = new FileReader("file1.txt");
			fw = new FileWriter("file1copy"+String.valueOf(time)+".txt");
			// 读一个字符，写一个字符方法
			// int ch = 0;
			//
			// while ((ch = fr.read()) != -1) {
			// fw.write(ch);
			// }
			char[] buf = new char[1024];
			int len = 0;
			// 读一个数组大小，写一个数组大小方法。
			while ((len = fr.read(buf)) != -1) {
				fw.write(buf, 0, len);
				//buf.
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (Exception e2) {
					throw new RuntimeException("关闭失败！");
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("关闭失败！");
				}
		}

	}

}
