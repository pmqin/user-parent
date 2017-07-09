/**
 * 
 */
package pmqin.com.XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
/** 
* @author : pmqin
* @date   : 2016年7月22日 下午11:20:09 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class createXML {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Document doc = DocumentHelper.createDocument();  
         Element root = doc.addElement("root");  
         Element father = root.addElement("father");  
         Element child = father.addElement("child");  
         Element name = child.addElement("name");  
         name.setText("十六笔画");  
         Element sex = child.addElement("sex");  
         sex.setText("男");  
         try {  
             PrintWriter pw = new PrintWriter("D:\\InstallSoft\\V2\\workspace\\user-parent\\user-test2\\wc.xml");  
             XMLWriter xw = new XMLWriter(pw);  
             xw.write(doc);  
             xw.flush();  
             xw.close();  
         } catch (FileNotFoundException e) {  
             e.printStackTrace();  
         } catch (IOException e) {  
             e.printStackTrace();  
         } finally {  
             System.out.println("Over");  
         }  
	}
	
	public void parseXML(){  
        File myXML = new File("D:\\InstallSoft\\V2\\workspace\\user-parent\\user-test2\\wc.xml");  
        SAXReader sr = new SAXReader();  
       try {  
           Document doc  =  sr.read(myXML);  
           Element root = doc.getRootElement();  
           for (Iterator fathers = root.elementIterator();fathers.hasNext();) {  
               Element father = (Element) fathers.next();  
               for (Iterator childs = father.elementIterator();childs.hasNext();) {  
                   Element child = (Element) childs.next();  
                   for (Iterator nodes = child.elementIterator();nodes.hasNext();) {  
                       Element node = (Element) nodes.next();  
                       System.out.println(node.getName()+"-----"+node.getText());  
                   }  
               }  
           }  
       } catch (DocumentException e) {  
           e.printStackTrace();  
       }  
   }  

}
