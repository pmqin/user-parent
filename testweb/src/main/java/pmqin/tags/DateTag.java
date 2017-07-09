/**
 * 
 */
package pmqin.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


// 属性的标签
public class DateTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String pattern = "yyyy-MM-dd hh:mm:ss";
	private Date date;

	// 必须要有Set方法，因为是属性可以设值
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	// @Override
	// public int doStartTag() throws JspException {
	// startTime = System.currentTimeMillis();
	// //表示定制标记里面有所包括的JSP页面
	// return TagSupport.EVAL_BODY_INCLUDE;
	// }

	public int doEndTag() throws JspException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 如果没有就是当前时间
		if (date == null) {
			date = new Date();
		}
		JspWriter out = pageContext.getOut();
		try {
			out.print(sdf.format(date));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//处理标签后，继续处理JSP后面的内容
		return TagSupport.EVAL_PAGE;
	}

}
