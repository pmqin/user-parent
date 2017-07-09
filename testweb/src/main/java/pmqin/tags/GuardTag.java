/**
 * 
 */
package pmqin.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/** 
* @author : pmqin
* @date   : 2016年7月22日 下午1:41:42 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class GuardTag extends TagSupport {


	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		String valid = pageContext.getRequest().getParameter("valid");

		// 如果flag设定为key，就显示本体文字内容
		if (valid.equals("valid_user")) {
			return EVAL_BODY_INCLUDE;
		}

		return SKIP_BODY;
	}

}
