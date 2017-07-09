package pmqin.com.parentandson;

public class parent {

	private static Integer A_INTEGE;
	private static String bString;

	public parent() {
		// TODO Auto-generated constructor stub
	}

	public parent(Integer a) {
		A_INTEGE = a;
	}

	public parent(Integer a, String b) {
		A_INTEGE = a;
		bString = b;
		System.out.println("父:" + A_INTEGE + bString);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
