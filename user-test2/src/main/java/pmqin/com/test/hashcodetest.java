/**
 * 
 */
package pmqin.com.test;


import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** * @author  作者 E-mail: * @date 创建时间：2015年12月14日 下午8:51:24 * @version 1.0 * @parameter  * @since  * @return TestApptest4.javaTODO */
/**
 * @author pmqin
 *
 */
public class hashcodetest implements Comparable<hashcodetest> {

	public static void main(String[] args) {
	  
		String longName="testdb.normaltabledemo";
		//String[] arrs = longName.split(".");//这个是错误的
		String[] arrs = longName.split("\\.");
		String[] aa = "aaa*bbb*ccc".split("\\*");
	    //String[] aa = "aaa|bbb|ccc".split("\\*"); 这样才能得到正确的结果 
		//显然, . + * |  不是有效的模式匹配规则表达式,用"\\*" "\\+","\\|"转义后即可得到正确的结果。
		//如果在一个字符串中有多个分隔符,可以用“|”作为连字符,比如,“acount=? and uu =? or n=?”,把三个都分隔出来,可以用String.split("and|or");
		//还有如果想在串中使用"\"字符,则也需要转义.首先要表达"aaaa\bbbb"这个串就应该用"aaaa\\bbbb",如果要分隔就应该这样才能得到正确结果,
		//
		//String[] aa = "aaa\\bbb\\bccc".split("\\\\");
				
		int dd=1<<8;

		//Collection<test4> items=new ArrayList<>();
		HashSet<hashcodetest> items=new HashSet<>();//相同的对象进不去,但是他们都是同一个引用
		hashcodetest item=new hashcodetest("qin",1);
		hashcodetest item1=new hashcodetest("qin1",2);
		hashcodetest item2=item;
		hashcodetest item3=new hashcodetest("qin",1);
		hashcodetest item4=new hashcodetest("qin23",3);
		boolean a0=items.add(null);
		boolean a1=items.add(item);
		boolean a11=items.add(item1);
		boolean a2=items.add(item2);
		boolean a3=items.add(item3);
		boolean a4=items.add(item4);
		//items.add(item);
	    
		
		item3.Id=3;
		items.remove(item3);//不要对参与了hashcode的属性进行修改,
		
		System.out.println("equals:"+item.equals(item3));
		System.out.println("=="+(item==item3));
		System.out.println("equals:"+item.equals(item2));
		System.out.println("=="+(item==item2));
		
		System.out.println(items.size());
		System.out.println("集合最大："+Collections.max(items));//必须实现Comparable<test4>
		System.out.println("集合最小："+Collections.min(items));//必须实现Comparable<test4>
		
		
		BigDecimal a=BigDecimal.valueOf(1);
	     BigDecimal b=BigDecimal.valueOf(1.000);
	     if(a.compareTo(b)==0)
	     {
	    	 
	    	 System.out.println("BigDecimal比较");
	    	 System.out.println("BigDecimal比较"+BigDecimal.ZERO);
	     }
	     System.out.println("BigDecimal比较"+a.compareTo(b));
		
		//ConcurrentHashMap<int, String> hash1=new ConcurrentHashMap<String, String>();
		HashMap<String, String> hash=new HashMap<String, String>();
		hash.put(null, null);
		hash.put(null, null);
		hash.put("fdsf", "fdsfsf");
		//hash.put("fdsf", "fdsfsf1");
		for(Map.Entry<String, String> entry: hash.entrySet())
		{
			System.out.println(entry.getValue()+"----"+entry.getKey());
		}
		
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);		
		Iterator<String> it1 = numbers.keySet().iterator();
        while(it1.hasNext()) {
        	System.out.println(it1.next());
       }
        double d=3*0.1;
        
        if (3*0.1 == 0.3) {
			System.out.println("3*0.1 == 0.3"+"---"+d);
		}
        else {
        	System.out.println("3*0.1 != 0.3"+"---"+d);
		}
        
        
		
	}
	 
	
	/*
	  如果已经手动写了 就不会自动生成
	
	public  String  GetName() {
		return "测试";
	}
	*/
	
	public hashcodetest() {
       
    }
//	public static MathContext mc = new MathContext(Id);
//	public static BigDecimal add(BigDecimal a1,BigDecimal a2){
//
//		   a1=null2Zero(a1);
//
//		   a2=null2Zero(a2);
//
//		   return a1.add(a2,mc);
//
//		}
//	public static BigDecimal null2Zero(BigDecimal arg){
//
//	    return arg==null ? BigDecimal.ZERO : arg ;
//
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		hashcodetest other = (hashcodetest) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}

	public hashcodetest(String name, int age) {
        this.Id=age;
        this.Name=name;
    }
	
	private Integer Id;
	private String Name;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	
	public String getName() {
	return Name;
	}

	public void setName(String name) {
	Name = name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "test4 [Id=" + Id + ", Name=" + Name + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(hashcodetest o) {
//		long thisTime = getMillisOf(this);
//        long anotherTime = getMillisOf(anotherDate);
//        return (thisTime<anotherTime ? -1 : (thisTime==anotherTime ? 0 : 1));
		return (this.Id<o.Id ? -1 : (this.Id==o.Id ? 0 : 1));
		
	}

	
}
