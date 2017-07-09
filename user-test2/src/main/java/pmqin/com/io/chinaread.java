package pmqin.com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class chinaread {

	public static void main(String[] args) {

		File file = new File("./jsonarry.txt");
		InputStream streamReader = null; // 文件输入流
		try {
			streamReader = new FileInputStream(file);

			byte[] buffer = new byte[streamReader.available()];

			// int numberRead = 0;
			// while ((numberRead = streamReader.read(buffer)) != -1) {//
			// 完整的一次性读
			// System.out.println("---正在读的是第： " + numberRead + " 字节");
			// // stringBuilder.append(new String(buffer, 0, readBytes));
			// System.out.println(new String(buffer));
			// }

			InputStreamReader reader = new InputStreamReader(streamReader, "GBK"); // 最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"
			BufferedReader br = new BufferedReader(reader);
			String line;
			//可以 GBK
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
