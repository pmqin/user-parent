package pmqin.com.test;

import java.text.SimpleDateFormat;
import java.util.*;

public class matchesest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int newCapacity = (10 << 1) + 1;
		 System.out.println(newCapacity);
		 String key="dt";
		 String day = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		   if (key.matches("d+t*")) {     
		 
			   System.out.println(day+"HH:"+new SimpleDateFormat("HH").format(new Date()));
		   }
		 
	}

}
