package pmqin.com.Collection;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HashMaptest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int yuwei=1;
		yuwei=yuwei<<2;
		System.out.println("yuwei="+yuwei );
		HashMap map = new HashMap();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		
		map.size();
		System.out.println(map);
		Set keys1 = map.keySet();
		Set keys2 = map.keySet();
		Set keys3 = map.keySet();
		keys1.remove(1);
		System.out.println(keys1);
		System.out.println(keys2);
		System.out.println(keys3);

		ArrayList<String> columnNames = new ArrayList<String>();
		LinkedHashMap<String, Object> dd = new LinkedHashMap<>();
		dd.put("qin", 1);
		dd.put("peng", 2.112);
		dd.put("peng11", Arrays.asList("2", "4", " -9"));
		dd.put("peng12", dd);
		String jsonString = JSON.toJSONString(dd);
		LinkedHashMap jsonMap = JSON.parseObject(jsonString, LinkedHashMap.class);
		Iterator iter = jsonMap.keySet().iterator();
		while (iter.hasNext()) {
			// if (iter.next() != null && iter.next() != "") {
			// 這個是下一個,所以注意點 不能判斷
			// 最好加一個temp
			Object key = iter.next();
			Object value = jsonMap.get(key);
			System.out.println(key + "---value:" + value + "=====" + value.getClass().getSimpleName());
			System.out.println("instanceof: "+(value instanceof JSONArray));
			if ( value instanceof JSONArray) {
				 JSONArray jsonArray = (JSONArray) jsonMap.get(key);
				 List list = handleJSONArray(jsonArray);
				 for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Object object = (Object) iterator.next();
					System.out.println("hhhhh:"+object);
				}
			}
		}
		System.out.println("付付付付付付付");
		Iterator iter2 = dd.entrySet().iterator();
	   
		int i = 0;
		while (iter2.hasNext()) {
			Map.Entry entry = (Map.Entry) iter2.next();
			if (entry.getKey() != null && entry.getKey() != "") {
				columnNames.add(entry.getKey().toString());
				if (i > 0) {
					System.out.println("/");
				}
				i++;
				System.out.println(entry.getKey() + "--" + entry.getValue() + " ---value getSimpleName-------"
						+ entry.getValue().getClass().getSimpleName());
			}
		}

		HashSet set = new HashSet(10);
		set.add("1");
		set.add("2");
		set.add("3");
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	 private static List<LinkedHashMap<String, Object>> handleJSONArray(JSONArray jsonArray) {
	        List list = new ArrayList();
	        for (Object object : jsonArray) {
	            if (object instanceof JSONObject) {
	                JSONObject jsonObject = (JSONObject) object;
	                HashMap map = new HashMap<String, Object>();
	                for (Map.Entry entry : jsonObject.entrySet()) {
	                    if (entry.getValue() instanceof JSONArray) {
	                        map.put((String) entry.getKey(), handleJSONArray((JSONArray) entry.getValue()));
	                    } else {
	                        map.put((String) entry.getKey(), entry.getValue());
	                    }
	                }
	                list.add(map);
	            } else {
	                list.add(object);
	            }
	        }
	        return list;
	    }

}
