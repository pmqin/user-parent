package pmqin.com.io;

import java.io.File;

public class createNewFiletest {

	public static void main(String[] args) {
		
		String str = "Output:"+System.getProperty("line.separator");  //在Android中System.getProperty("line.separator")的结果是\n，在JAVA中则是\r\n。
		System.out.println(System.getProperty("user.dir"));
		System.out.println("classpath: " + System.getProperty("java.class.path"));
		 File f=new File("./create.txt");  
	        try{  
	            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。  
	            System.out.println("该分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G"); //返回由此抽象路径名表示的文件或目录的名称。  
	            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。  
//	            f.delete(); //  删除此抽象路径名表示的文件或目录  
	           System.out.println("文件名  "+f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。  
	           System.out.println("文件父目录字符串 "+f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。  
	            
	        }catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  }  

	

}
