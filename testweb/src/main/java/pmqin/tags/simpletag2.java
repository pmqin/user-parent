/**
 * 
 */
package pmqin.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//改变标签体内容并输出到浏览器
public class simpletag2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		//JspFragment jFragment = this.getJspBody();
		 //获取到标签体内容，并保存到自定义的款冲字符流中
		StringWriter sWriter=new StringWriter();
		//jFragment.invoke(sWriter);
		 //jspBodyString得到的即是标签体的内容
		String jspBodyString=sWriter.toString();
		jspBodyString=jspBodyString.toUpperCase();
		jspBodyString = "简单将字符串的值改变掉";
		
		this.getJspContext().getOut().write(jspBodyString);//输出到浏览器
	}

}
