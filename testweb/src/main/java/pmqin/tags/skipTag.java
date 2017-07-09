/**
 * 
 */
package pmqin.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class skipTag extends TagSupport {

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return TagSupport.SKIP_PAGE;
		// SKIP_BODY 表示不用处理标签体，直接调用doEndTag()方法。
		//
		// SKIP_PAGE 忽略标签后面的JSP内容。
		//
		// EVAL_PAGE 处理标签后，继续处理JSP后面的内容。
		//
		// EVAL_BODY_BUFFERED 表示需要处理标签体。
		//
		// EVAL_BODY_INCLUDE 表示需要处理标签体,但绕过setBodyContent()和doInitBody()方法
		//
		// EVAL_BODY_AGAIN 对标签体循环处理。
	}

}
