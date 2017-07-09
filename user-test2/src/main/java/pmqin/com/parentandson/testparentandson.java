package pmqin.com.parentandson;

public class testparentandson {
	static String  s= "a"+"b"+"c";
	static String  s1= "abc";	
	public static void main(String[] args) {
		
		parent parent=new parent(1, "parent");
		
		parent parentson=new son(1,"parentson"); 
		
		son son=new son(1,"son"); 
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
	}

}
