package pmqin.com.everyday;

public class day3 {

	/*
	 * 反序列化时构造函数是不会执行的，反序列化的又一原则。反序列化的执行过程就是JVM从数据流中获取Object对象，
	 * 再根据流中的类文件描述信息查看发现有final变量，就要重新计算，那么就引用Ques1114类的num值，
	 * 但此时JVM又发现num没有赋值，构造函数又不会执行，所以就不再初始化，保持原本的值，就是123
	 * 反序列化时final被重新赋值，其中的“值”指的是简单对象（包括8个基本类型、数组、不使用new关键字生成String对象的字符串），但如果使用方法赋值的话是不会重新计算的。
	 */
	private static final long serialVersionUID=1L;
	  public final int num = init();  // 通过方法赋值

	   public int init(){
	      return 123;
	   }
	public static void main(String[] args) {
		

		 

	}

}
