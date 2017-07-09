package pmqin.com.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		FileReader FileReader=  new FileReader ("./jsonarry.txt");
        BufferedReader br = new BufferedReader (FileReader);//提供更多的讀取功能//不然就是一個一個讀取字符
       
        String s;
        
         while ((s = br.readLine() )!=null) {

             System.out.println(s);

          }

         FileReader.close();
        
        
      

	}

}
