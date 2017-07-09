package pmqin.com.everyday;

//其实是空(null)，而并没有被赋值。那么打印出null是为什么呢？我们查看PrintStream的源码就很清晰的明白了，其实是Java在println的时候进行了处理。
public class day4 {

	 private static String a;
	 private static String b; 
	public static void main(String[] args) {
		 System.out.println(a==null); 
	       System.out.println("null".equals(a)); //上述代码输出分别是true,false
	       String c = a+b; //String的相加,由于编译器的优化，最终代码为通过StringBuilder完成处理成了StringBuilder builder = new StringBuilder(); 的append连续了2次
	       System.out.println(c); //所以是nullnull
	       //http://blog.csdn.net/java2000_net/article/details/3681385  String s = a+b+c+d+e;创建了几个对象的详细分析?
	       StringBuilder builder = new StringBuilder(); 
	}
	
//	public void print(String s) { 
//	    if (s == null) { 
//	        s = "null"; 
//	    } 
//	    write(s); 
//	    } 

}
