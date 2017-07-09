/**
 * 
 */
package pmqin.com.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;


/** 
* @author : pmqin
* @date   : 2016年7月22日 下午11:17:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class PullParserTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	
		//File keyTabFile = new File("persontest.xml");
		System.out.println("fdsfsdf");
		InputStream streamReader =new FileInputStream(new File("F:\\WorkSpace\\user-parent\\user-test2\\src\\main\\resources\\persontest.xml"));  
		//InputStream streamReader =new FileInputStream("persontest.xml"); 
		List<Person> list=getPersonsFromXML(streamReader);
		 for (Person person : list) {
			System.out.println(person.toString());
		}
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	     String time = format.format(Calendar.getInstance().getTime());
		 OutputStream streamWirte=new FileOutputStream(new File("F:\\WorkSpace\\user-parent\\user-test2\\src\\main\\resources\\personWite"+time+".xml"));
		 saveDataToXML(list,streamWirte);
	
	}
	
	/*
	 * 读取xml文件代码
	 */
	public static List<Person> getPersonsFromXML(InputStream xml) throws Exception{  
        List<Person> persons = null;  
        Person person = null;  
       //Android中获取PULL XML解析器，也可以使用XmlPullParserFactory.newInstance().newPullParser();  
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser(); //Xml.newPullParser();  
        parser.setInput(xml, "UTF-8");  
        int event = parser.getEventType();  
        while(event != XmlPullParser.END_DOCUMENT){//和SAX类似，PULL也使用startDocument和endDocument事件来判断文件的开始和结束  
            switch(event){  
            case XmlPullParser.START_DOCUMENT:  
                persons = new ArrayList<Person>();  
                break;  
            case XmlPullParser.START_TAG://类似SAX的startElement事件，XML节点开始  
                if("person".equals(parser.getName())){  
                    person = new Person();  
                    person.setId(Integer.parseInt(parser.getAttributeValue(0)));  
                    //String number =parser.getAttributeValue(null,"cityname");　　//null：固定值；cityname：属性的名字
                }  
                if("name".equals(parser.getName())){  
                    person.setName(parser.nextText());  
                }  
                if("age".equals(parser.getName())){  
                    person.setAge(Integer.parseInt(parser.nextText()));  //xml解析获得文本属性parser.nextText(); 注意：这边if条件中获取的是name标签开始的位置 因此用nextText()方法获取标签体内容
                }  
                break;  
            case XmlPullParser.END_TAG://类似SAX的endElement事件，XML节点结束  
                if("person".equals(parser.getName())){  
                    persons.add(person);  
                    person = null;  
                }  
                break;  
            }  
            event = parser.next();//获取解析器中下一个事件  
        }  
        return persons;  
    }  
	
	/*
	 * 写xml代码
	 */
	public static void saveDataToXML(List<Person> persons, OutputStream os) throws Exception{  
        XmlSerializer serializer = XmlPullParserFactory.newInstance().newSerializer();  
        serializer.setOutput(os, "UTF-8");  
        serializer.startDocument("UTF-8", true);//第二个参数设置该xml是否为standalone  
        serializer.startTag(null, "persons");//第一个参数为命名空间  
        for(Person person : persons){  
            serializer.startTag(null, "person");  
            serializer.attribute(null, "id", Integer.toString(person.getId()));  
              
            serializer.startTag(null, "name");  
            serializer.text(person.getName());  
            serializer.endTag(null, "name");  
              
            serializer.startTag(null, "age");  
            serializer.text(Integer.toString(person.getAge()));  
            serializer.endTag(null, "age");  
              
            serializer.endTag(null, "person");  
        }  
        serializer.endTag(null, "persons");  
        serializer.endDocument();  
        os.flush();  
        os.close();  
    }  

}
