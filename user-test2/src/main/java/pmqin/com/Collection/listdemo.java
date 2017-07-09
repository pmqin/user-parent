package pmqin.com.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class listdemo {

	public static void main(String[] args) {
		// http://www.jb51.net/article/45660.htm java list用法示例详解
		// 注意：
		// 在迭代时，是不可以通过集合对象的方法操作集合中的元素
		// 因为会发生ConcurrentModificationException异常（并发异常）
		// 所以，在迭代器时，只能用迭代器的方法造作元素
		// 因为Iterator方法是有限的所以只能对元素进行判断，取出，删除的操作
		// 如果想要其他的操作如添加，修改等，就需要使用其子接口，ListIterator
		// 该接口只能通过List集合的listIterator方法获取
		
		
		
		List<String> list = new ArrayList<String>();

		list.add("d=2015-05-26/hour=18"); // 向列表中添加数据

		list.add("d=2015-05-27/hour=18"); // 向列表中添加数据

		list.add("d=2015-05-27/hour=20"); // 向列表中添加数据
		List<Map<String, String>> TablePartitionMap = new ArrayList<>();
		for (String string : list) {
			HashMap<String, String> item = new HashMap<>();
			String[] arrs = string.split("/");// 属性
			for (int i = 0; i < arrs.length; i++) {
				String[] itemKV = arrs[i].split("=");// 属性
				item.put(itemKV[0], itemKV[1]);
			}

			TablePartitionMap.add(item);
		}
		List<String> list2 = new ArrayList<String>();

		list.add("第一个元素"); // 向列表中添加数据

		list.add("第二个元素"); // 向列表中添加数据

		list.add("第三个元素"); // 向列表中添加数据
		
		List<String> list1 = new ArrayList<String>();
		list1.add("第一个元素"); // 向列表中添加数据
		list1.add("第三个元素"); // 向列表中添加数据
		
		
		boolean ret = list2.retainAll(list1);//取得两个List的交集

		if (ret) {

			System.out.println("元素被移除成功");
			System.out.println(list2);

		} else {
			System.out.println(list2);
			System.out.println("列表中不包含要移除的元素");

		}
		int d = list1.indexOf("第一个元素");
		System.out.println("列表中第一个元素的index：" + d);
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("dgfd", "dgfd");
		hashtable.contains("");
		hashtable.containsValue("");
		TreeMap<String, String> TreeMap = new TreeMap<String, String>();
		TreeMap.put("dgfd", "dgfd");
		HashMap<String, String> HashMap = new HashMap<String, String>();
		HashMap.put("dgfd", "dgfd");
		HashMap.get("");
		HashMap.containsValue("");
		System.err.println("------------------------");
		
		
		List<Student>  list3=new ArrayList<>();
		list3.add(new Student(16, "Jerry"));
		list3.add(new Student(4116, "Jerry"));
		list3.add(new Student(416, "Jerry"));
		//list.remove(new Student(416, "Jerry"));		
//		System.err.println("------------------------");

		
		Iterator<Student>  iterators= list3.iterator();
		while (iterators.hasNext()) {
			Student student = (Student) iterators.next();
			if (student.getStuNum()==16) {
				iterators.remove();
			}
//			System.out.println("dddddddddddddddd");
//			System.out.println(student.getStuNum() + " --- " + student.getName());
		}
		//剩下
		for(Student student:list3)
		{
			System.out.println(student.getStuNum() + " --- " + student.getName());
		}
		

	}

}
