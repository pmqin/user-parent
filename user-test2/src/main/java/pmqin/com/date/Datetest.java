package pmqin.com.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datetest {

	public static void main(String[] args) {

//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        String time = format.format(Calendar.getInstance().getTime());
//        System.out.println("完整的日期时间 " + time);
        
		//http://blog.csdn.net/u010257060/article/details/25725529
        Calendar c = Calendar.getInstance();          
        System.out.println(c);  
          
        String demo = datechange(c.getTime(), "yyyy年MM月dd日");  
        String demo1 = datechange(c.getTime(), "yyyy-MM-dd HH:mm:ss SSS");  
        String demo2 = datechange(c.getTime(), "yyyy-MM-dd");  
        String demo3 = datechange(c.getTime(), "HH-mm-ss SSS");  
       String demo4 = datechange(new Date(), "yyyy-MM-dd E");  
       
        System.out.println("年月日："+demo);  
        System.out.println("完整的日期和时间："+demo1); 
        System.out.println("完整的日期："+demo2); 
        System.out.println("完整的时间："+demo3);
        System.out.println("完整的日期：星期："+demo4);
        
        System.out.println("完整的时间1： " + getCurrentTimeString());
        System.out.println("完整的时间2： " + getTodayAndTime());
        
        //当前系统时间，这个构造函数在内部使用了System.currentTimeMillis()方法来从系统获取日期   
        Date date = new Date();    
      //返回时间的long类型（毫秒数）  
        System.out.println("long类型（毫秒数）："+date.getTime());    
        System.out.println("年份x-1900："+date.getYear());   
        System.out.println("月份 0-11："+date.getMonth());
        System.out.println("几号："+date.getDate()); 
        System.out.println("星期 ："+date.getDay());
        System.out.println("小时（0-23）："+date.getHours());
        System.out.println("分钟（0-59）："+date.getMinutes());   
        System.out.println("秒（0-59）："+date.getSeconds());         
        
	}
	
	public static  String getTodayAndTime() {
		return new Timestamp(System.currentTimeMillis()).toString();
	}
	/**
     * 获取当前时间yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentTimeString(){

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    public static String datechange(Date date, String pattern) {  
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
        String demo = sdf.format(date);  
        return demo;  
    }  
    
    public static Date datechange(String strdate, String pattern) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
        Date date = sdf.parse(strdate);  
        // long day =(date.getTime()-mydate.getTime())/(24*60*60*1000);  
        return date;  
    }  

}
