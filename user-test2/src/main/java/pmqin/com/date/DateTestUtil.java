package pmqin.com.date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTestUtil {

public static void main(String[] args) throws Exception {
	
	String versionNum1="01";
	String dateversion122=versionNum1.substring(0,1);
	 System.out.println(dateversion122);
	String dateversion12=versionNum1.substring(1,2);
	 System.out.println(dateversion12);
	String versionNum="201407021030045756";
			String dateversion=versionNum.substring(0,8);
			String dateversion1=versionNum.substring(8,10);
			 System.out.println(dateversion);
			 System.out.println(dateversion1);
			 
     String dtr="d=2015-05-29/hour=20";
     System.out.println(dtr.length());
	String offset="-0d";
	int offsetUnitIndex=offset.lastIndexOf("d");
	String dayStr=offset.substring(0, offsetUnitIndex);
	Integer day=Integer.valueOf(dayStr);
	System.out.println(day);
	  int d=day/24;
	
	  int h=day%24;
	  String key="hour=18";
	  if (key.matches("^hour.*") || key.matches(".*hour$")) { 
		  System.out.println("^hour.* 查找以hour开头,任意结尾的字符串");
	  }
	  String key1="d";
	  if (key1.matches("^d.*")) { 
		  //if (key1.matches("dt?")) { 
		  System.out.println("d为起始字符");
	  }
	  
	  
	  
	  System.out.println(d);
	  System.out.println(h);
	  System.out.println( Math.abs(h));
	  if (Math.abs(h)<=9) {
		String  hour="0"+Math.abs(h);
		 System.out.println("hour"+hour);
	}
	 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String str="20110823";
        Date dt=sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
//        rightNow.add(Calendar.YEAR,-1);//日期减1年
//        rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR,-1);//日期加10天
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println("777777777"+reStr);
         
       String day1= reStr.substring(0,4)+"-"+reStr.substring(4,6)+"-"+reStr.substring(6,8); 
       System.out.println(day1);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("timestamp"+timestamp);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timestamp);
		System.out.println("fsdfsdf"+calendar);
		
		
		java.util.Date date =calendar.getTime();
		System.out.println(date);

    }

	
}
