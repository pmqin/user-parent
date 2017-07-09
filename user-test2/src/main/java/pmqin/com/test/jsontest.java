package pmqin.com.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class jsontest {

	public static void main(String[] args) {
		// String src = new String("ab43a2c43d");
		// System.out.println(src.replaceAll("\\d","f"));
		// System.out.println(jsonString2.replaceAll("\\\\",
		// ""));//每四个是一个真正的\;将字符串中的"\"替换成"\\"：msgOut=msgIn.replaceAll("\\\\","\\\\\\\\");
		Map dd = new LinkedHashMap<>();
		dd.put("qin", "1");
		dd.put("peng", 1.2);
		dd.put("pen1g", 1);
		String jsonString = JSON.toJSONString(dd);
		boolean index = jsonString.trim().startsWith("{");
		System.out.println(index);
		System.out.println(jsonString);
		LinkedHashMap jsonMap = JSON.parseObject(jsonString, LinkedHashMap.class);
		
		Iterator iter = jsonMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
//	  try {

		String jsonString2 = JSON.toJSONString(jsonString);
		System.out.println("第二次json：" + jsonString2);
		boolean index2 = jsonString2.trim().startsWith("{");
		System.out.println("第二次"+index2);
		jsonString2 = JSON.parseObject(jsonString2, String.class);
		System.out.println("把经过2次json的字符串反解析成原始的json的结果：" + jsonString2);
		LinkedHashMap jsonMap1 = JSON.parseObject(jsonString2, LinkedHashMap.class);
		Iterator iter1 = jsonMap1.entrySet().iterator();
		while (iter1.hasNext()) {
			Map.Entry entry = (Map.Entry) iter1.next();
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
		System.out.println("-------------第二次解析结果完成------------------");

		jsonString2 = JSON.toJSONString(jsonString2);
		System.out.println("第二次json:" + jsonString2);
		jsonString2 = JSON.toJSONString(jsonString2);
		System.out.println("第三次json:" + jsonString2);
		jsonString2 = JSON.parseObject(jsonString2, String.class);
		System.out.println("第三次反解析对象第一步:" + jsonString2);
		jsonString2 = JSON.parseObject(jsonString2, String.class);
		System.out.println("第三次反解析对象第二步" + jsonString2);
		boolean index22 = jsonString2.trim().startsWith("\"");
		char chanrindex=jsonString2.charAt(0);
		System.out.println( String.valueOf(chanrindex).equals("{"));
		System.out.println("index22"+index22);
		LinkedHashMap jsonMap2 = JSON.parseObject(jsonString2, LinkedHashMap.class);
		Iterator iter3 = jsonMap2.entrySet().iterator();
		while (iter3.hasNext()) {
			Map.Entry entry = (Map.Entry) iter3.next();
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
		System.out.println("----------------第三次解析结果完成------------------");

		System.out.println("原始json:" + jsonString2);
		String jsonString3 = JSON.toJSONString(jsonString2);
		System.out.println("再第二次json:" + jsonString3);
		jsonString3 = jsonString3.substring(1, jsonString3.length() - 1).toString();
		System.out.println("减去引号的结果：" + jsonString3);
		// jsonString3 = jsonString3.replaceAll("\\\\", ""); //把2次json的的 \
		// 替换成 空
		jsonString3 = jsonString3.replaceAll("\\\\\\\"", "\""); // 把2次json的的
																// \"
																// 替换成 "
		System.out.println("替换：" + jsonString3);
		LinkedHashMap jsonhashmap = JSON.parseObject(jsonString3, LinkedHashMap.class);
		Iterator iter111 = jsonhashmap.entrySet().iterator();
		while (iter111.hasNext()) {
			Map.Entry entry = (Map.Entry) iter111.next();
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}

		System.out.println("----------------测试3次------------------");

		String jsonString4 = JSON.toJSONString(jsonString3);
		// jsonString4=JSON.toJSONString(jsonString4);
		System.out.println("第3次json：" + jsonString4);
		jsonString4 = jsonString4.substring(1, jsonString4.length() - 1);
		System.out.println("减去引号的结果：" + jsonString4);
		jsonString4 = jsonString4.replace("\\\\", "\\");
		System.out.println("第一次替换：" + jsonString4);
		jsonString4 = jsonString4.replace("\\\"", "\"");
		System.out.println("第二次替换：" + jsonString4);
		LinkedHashMap resultMap = JSON.parseObject(jsonString2, LinkedHashMap.class);
		Iterator iter5 = resultMap.entrySet().iterator();
		while (iter5.hasNext()) {
			Map.Entry entry = (Map.Entry) iter5.next();
			System.out.println(entry.getKey() + "----" + entry.getValue().getClass().getSimpleName()+"++"+entry.getValue());
		}
		
		Iterator sss=resultMap.keySet().iterator();
		while (sss.hasNext()) {
			System.out.println(sss.next()); 
			
		}
//		 } catch (Exception e) {
//		 System.out.println(e.getMessage());
//		 System.out.println(e.getMessage().equals("syntax error, expect {, actual string"));
//		 System.out.println(e.getMessage().equals("illegal identifier : \\"));
//		 }

	}

}
