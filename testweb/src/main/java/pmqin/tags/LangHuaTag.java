/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class LangHuaTag extends TagSupport {

	private long startTime;
	private long endTime;

	@Override
	public int doStartTag() throws JspException {
		startTime = System.currentTimeMillis();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 表示定制标记里面有所包括的JSP页面
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		HttpServletRequest request= (HttpServletRequest)this.pageContext.getRequest();
		String ip=request.getRemoteAddr();
		
		try {
			JspWriter out = this.pageContext.getOut();
			out.println("runtime is " + elapsed+",您的IP:"+ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 表示JSP页面继续运行
		return TagSupport.EVAL_PAGE;
	}

}
