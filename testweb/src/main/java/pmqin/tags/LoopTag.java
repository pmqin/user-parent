/**
 * 
 */
package pmqin.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//循环输出 
public class LoopTag extends TagSupport {

	//参数只支持八种基本数据类型转换
	private int times = 0;

	// Set方法设值
	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public int doStartTag() throws JspException {
		// 表示定制标记里面有所包括的JSP页面
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (times > 1) {
			times--;
			// 表示从标签开始输入
			return TagSupport.EVAL_BODY_AGAIN;
		}
		// 表示结束，忽略标签内部的内容
		return TagSupport.SKIP_BODY;
	}

}
