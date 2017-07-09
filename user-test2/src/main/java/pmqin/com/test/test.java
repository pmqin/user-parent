package pmqin.com.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

import static java.lang.Math.*;

/*
 * @author pmqin
 * @date 2015-12-13
 * @version v1.0
 */
public class test {

	private static List<String> tblColumnName=new ArrayList<>();
	private  static List<String> tblcolumnTypes=new ArrayList<>(); 

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		System.out.println(' '==32);
		String ss="qin@ctrim.com,quqq@ctrip.com";
		String[ ] ddd=ss.split("\\s*,\\s*");
		System.out.println(ddd[0]+"----"+ddd[1]);
		Integer zeusJobId=0;
		Integer zeusJobIdLength="1445450001230".length();//001270
		String zeusJobIdVersion ="1445450001230".substring(zeusJobIdLength-6);
		char[] chArarry=zeusJobIdVersion.trim().toCharArray();
		Integer jobIdStartIndex=0;
		for (int i = 0; i < chArarry.length; i++) {
			char c = chArarry[i];
			zeusJobId=Integer.valueOf(c+"");
			if (zeusJobId>0) {
				jobIdStartIndex=i;
				break;
			}
		}
		String zeusJobIdstr=zeusJobIdVersion.substring(jobIdStartIndex);
		System.out.println("zeusJobIdstr:"+zeusJobIdstr);
		
		String PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE = test.class.getName() + ".pathWithinHandlerMapping";
		System.out.println(PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		tblColumnName.add("dasdas");
		String key="qin";
		String key1="qin1";
		int reducer=key1.hashCode()& Integer.MAX_VALUE;
		System.out.println("hashCode"+reducer);
		
		Inner my = new Inner();
		System.out.println(my.a);
		System.out.println(my.b);// 全局的静态变量
		System.out.println(my.c);
		
		Inner my2 = new Inner();
		System.out.println(my2.a);
		System.out.println(my2.b);
		System.out.println(my2.c);
		System.out.println("直接访问形式 C:" + Inner.c);

		StringTokenizer st = new StringTokenizer("www.ooobj.com", ".ob", true); // 把.
																				// o
																				// b
																				// 三个char作为分隔符，是否返回分隔符的的字符串
		while (st.hasMoreElements()) {
			System.out.println("Token:" + st.nextToken());
		}

		test test1 = new test();
		test.Book book = test1.new Book();
		test.Book book1 = test1.getBookInstance();
		test.Book book2 = new test().getBookInstance();
		// 区别是一个实例化了 ,一个有实例化
		test.Inner inner = new test.Inner();
		test.Inner inner1 = test1.getInnerInstance();
		my.name1();
		my.name2();
		test.Inner.name2();//都可以访问静态方法
		System.out.println(max(12, 121));
		System.out.println(abs(1 - 8));
		System.out.println(add(1, 2, 3));

		Integer aInteger = 132;
		Integer bInteger = 132;

		System.out.println(aInteger == bInteger);
		String s1 = new String("a");
		String s2 = new String("b");
		System.out.println(s1.equals(s2));

		System.out.println(((Inner) null).c);

		System.out.println("开始测试静态数据的初始化");
		TestStatic jjj = new TestStatic();
		// static final TestStatic jjj1=new TestStatic();
		

		String string = "1";
		String dd = string.intern();
		String string1 = "1";
		System.out.println(string == string1);

		String s = "my.test.txt";
		System.out.println(s.replace(".", "#"));

		UUID uuid = UUID.randomUUID();
		System.out.println("UUID" + uuid + "uuid:" + getUUID(uuid));
		uuid = UUID.randomUUID();
		System.out.println("UUID" + uuid);

		Loop: for (int i = 2; i < 10; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0)
					continue Loop;
			}
			System.out.print(i + " ");
		}

		System.out.println(8 % 8);
		test.BookDetail bookDetail = test1.new BookDetail();
		bookDetail.Name="qinpengming";
		name(bookDetail);

	}

	//// 去掉UUID“-”符号
	public static String getUUID(UUID uuid) {
		String s = uuid.toString();

		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	public static void getname() {

	}
	public  static void  name(BookDetail context) {
		System.err.println(context.getName());
	}
	/// 可变参数，...前后空格没有问题
	public static int add(int... args) {

		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
    
	
	public class BookDetail {
		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		private Integer Id;
		private String Name;
	}

	public class Book {
		List<BookDetail> details = new ArrayList<BookDetail>();
		// @Deprecated // 建议不要使用，已经被新特新所取代，类似于C#的特新
		// public static int addd=12;
		//
		// public static String setName(String name) {
		// return name;
		// }

	}

	// 非静态实例
	public Book getBookInstance() {
		return new Book();
	}

	public Book getBookInstance2() {
		return new Book();
	}

	// 静态实例
	public Inner getInnerInstance() {
		return new Inner();
	}

	public Inner getInnerInstance2() {
		return new Inner();
	}

	int d = 10;
	private static int ab = 10;

	static class Inner {
		public int a;
		public static int b;
		public static int c;

		static {
			c += 100;
		}

		public Inner() {
			a++;
			b++;
			test item = new test();

			System.out.println(ab);
			System.out.println(item.d);

		}

		public void name1() {
           System.out.println("Inner Instance function");
		}

		public static void name2() {
			System.out.println("Inner static function");
		}
		/*
		 * 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，
		 * 这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法，这点很好理解，因为在没有外部类的对象的情况下，
		 * 可以创建静态内部类的对象，如果允许访问外部类的非static成员就会产生矛盾，因为外部类的非static成员必须依附于具体的对象。
		 * 但是可以通过实例化外部类来访问。
		 */
	}

}
