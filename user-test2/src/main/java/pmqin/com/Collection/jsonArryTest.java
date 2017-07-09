package pmqin.com.Collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import pmqin.com.io.InputStreamtest;

public class jsonArryTest {

	public static void main(String[] args) throws IOException {
		String fileName = "./jsonarry.txt";
		byte[] bytes = Files.readAllBytes(Paths.get(fileName));
		String content = new String(bytes,"gbk");//解决乱码
		//String content = new String(bytes);
		
		//String content = InputStreamtest.getFileContent(fileName);//都可以
		System.out.println(content);
		
		// System.out.println(text);
		List<LinkedHashMap> jsonarryMap1 = JSON.parseArray(content, LinkedHashMap.class);
		for (LinkedHashMap jsonMap : jsonarryMap1) {
			Iterator iter = jsonMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				System.out.print(entry.getKey() + "--" + entry.getValue() +"  ");
			}
			System.out.println();
		}
	}

}
