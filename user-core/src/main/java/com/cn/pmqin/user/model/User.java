package com.cn.pmqin.user.model;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.junit.experimental.theories.Theories;

@Entity
@Table(name = "User")
public class User extends TestStatic {

	private static final long serialVersionUID = 1L;
	public final double i = Math.random();// 每次得到的结果不一样
	private final static int finalID;
	private static int finalID2;
	private int finalID3;
	
	static  {
		 System.out.println("派生类 Static 静态语句块"); 
		finalID=1000;
	}
	
	{
		System.out.println("派生类  非静态语句块");  
		finalID2+=1;
		finalID3+=1;
	}
	
	/** full constructor */
	public User(Integer id, String mobileNo, String userName, String adderName) {
		System.out.println("派生类  默认无参构造器");  
		this.id = id;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.adderName = adderName;
	}
	public static void IintTest() {
    	System.out.println("派生类 Static Iint");
	}
	/**
	 * @param userName
	 * @param adderName
	 * @param mobileNo
	 */
	public User(String userName, String adderName, String mobileNo) {
		this(1, mobileNo, userName, adderName);// 必须在第一行，不能与基类的super();共存
		this.userName = userName;
		this.adderName = adderName;
		this.mobileNo = mobileNo;
	}

	public User(User cloneUser) {
		this(cloneUser.id, cloneUser.userName, cloneUser.adderName, cloneUser.mobileNo);
		
		this.id = cloneUser.id;
		this.userName = cloneUser.userName;
		this.adderName = cloneUser.adderName;
		this.mobileNo = cloneUser.mobileNo;
	}
	
	User coneUser=null;
	public void ConeUser() {
		coneUser=this;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", adderName=" + adderName + ", mobileNo=" + mobileNo + "]";
	}

	private Integer id;

	private String userName;

	private String adderName;

	private String mobileNo;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdderName() {
		return adderName;
	}

	public void setAdderName(String adderName) {
		this.adderName = adderName;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo; 
	}
	public final void Out1(int x )
    {
            System.out.println("Out1 number is "+x);
    }
    public void Out1(String s,int x )
    {
            System.out.println("Out2 number is "+x+";String is "+s);
    }
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    
	public static void main(String[] args) {

		User user = new User(1, "18801524512", "frank", "上海");		
		User userCopy = user; // 浅拷贝，公用了一个对象，对象值改变，另外一个也改变了
//		userCopy.ConeUser();
		User userClone = new User(user);// 深拷贝
//		List<User> users=new LinkedList();
		
		
//		userClone.setAdderName("北京");		
//		user.setAdderName("深圳");
//		System.out.println(user);
//		System.out.println("深拷贝" + userClone);
//		System.out.println("浅拷贝" + user);
		System.out.println("浅拷贝" + user.finalID2);
		
		/*TestStatic.Iint();
		User.IintTest();
		System.out.println(User.finalID);
		TestStatic user = new User(1, "18801524512", "frank", "上海");
		
		System.out.println();
		System.out.println("第二次初始化");*/
		//TestStatic user1 = new TestStatic();
//		TestStatic.Iint();//User.Iint();
//		User.IintTest();
//		System.out.println(User.finalID);
//		TestStatic user = new User(1, "18801524512", "frank", "上海");
//		System.out.println();
//		System.out.println("第二次初始化派生类");
//		User user2 = new User(1, "18801524512", "frank", "上海");
//		System.out.println();
//		System.out.println("第三次次初始化基类");
//		TestStatic user3 = new TestStatic ();
	}
}
