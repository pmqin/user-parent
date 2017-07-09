package pmqin.com.everyday;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class day1 {

	public static void main(String[] args) throws Exception {
		day1 day1=new day1();
		
		SortedSet<people> set=new TreeSet<people>();
		set.add(day1.new people("XIAOSAN",170));
		set.add(day1.new people("XIAOSI",165));
		set.add(day1.new people("LISI",178));
		for (people people : set) {
			System.out.println("getHeight"+people.getHeight());
		}
		//將升高矮的變高
		System.out.println("將升高矮的變高,但是并不改變原來的排序，treeset只能適合不變的集合，在插入的時候進行比較，");
		set.first().setHeight(180);
		for (people people : set) {
			System.out.println("將升高矮的變高getHeight"+people.getHeight());
		}
		System.out.println("重新排序");
		set=new TreeSet<>((new ArrayList<people>(set)));
		for (people people : set) {
			System.out.println("重新排序getHeight"+people.toString());
		}
		
		day2 day2=new day2();
		day2.setNum("sdsd");
		System.out.println(day2.getNum());
		
		
		Exception exception;//静态check
		if (true) {
			exception=new Exception("new的Exception消息");
			throw exception;
			
		}
		
		
	}
	
	class people implements Comparable<people>
	{
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name+"-------"+height;
		}

		public  people(String name,int height) {
			super();
			this.name=name;
			this.height=height;
			
		}
		private int height;
        private String name;
		

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		@Override
		public int compareTo(people o) {
			// TODO Auto-generated method stub
			return height-o.height;
		}
	}
}
