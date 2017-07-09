/**
 * 
 */
package pmqin.com.XML;

import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

/** 
* @author : pmqin
* @date   : 2016年7月22日 下午10:59:34 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class XmlRead {

	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document read = reader.read("test.xml");
		Element rootElement = read.getRootElement();
		//普通方式
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if("002".equals(element.attributeValue("id"))){
                List<Element> elem = element.elements();
                for (Element e : elem) {
                    if("002".equals(e.attributeValue("id"))){
                        Element nameElement = e.element("name");
                        System.out.println("普通方式: "+nameElement.getText());
                    }
                }
            }
        }
        
        
      //xpath方式
        Element nameElement = (Element)rootElement.selectSingleNode("/root/class[@id='002']/student[@id='002']/name");
        System.out.println(nameElement.getParent().getPath());
        System.out.println("xpath方式: "+nameElement.getText());
	}
	
}
