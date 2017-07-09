package pmqin.com.parentandson;

public class son extends parent {

	public son(Integer a, String b) {		
		super(a, b);
		System.out.println("son extends parent 是先初始化父类");
		// TODO Auto-generated constructor stub
	}

	//如果父类没有参数的构造函数，子类继承的时候一定要实现其中一个有参数的构造函数
//	public son(Integer a) {
//		super(a);
//		// TODO Auto-generated constructor stub
//	}

}
