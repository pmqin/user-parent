/**
 * 
 */
package pmqin.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;


@SuppressWarnings("serial")
public class DateConvert extends TagSupport {
	
//	2.TagSupport类的主要属性：
//	A.parent属性：代表嵌套了当前标签的上层标签的处理类 
//	B.pageContex属性：代表Web应用中的javax.servlet.jsp.PageContext对象 

//	3.JSP容器在调用doStartTag或者doEndTag方法前，会先调用setPageContext和setParent方法，设置pageContext和parent。因此在标签处理类中可以直接访问pageContext变量 

//	4.在TagSupport的构造方法中不能访问pageContext成员变量，因为此时JSP容器还没有调用  setPageContext方法对pageContext进行初始化 

	
	
	private String longTime; 
	@Override  
    public int doStartTag() throws JspException {  
        long l = 0l;  
        if (longTime!=null&&!longTime.equals("")) {  
            l = Long.parseLong(longTime);  
        }  
        Date date = new Date(l);  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String targetTime = format.format(date);  
        try {  
            super.pageContext.getOut().write(targetTime);  
        } catch (IOException e) { 
           
            throw new RuntimeException(e);
        }  
        return super.doStartTag();  
    }  
      
    //setter and getter  
    public void setLongTime(String longTime) {  
        this.longTime = longTime;  
    }  
}
