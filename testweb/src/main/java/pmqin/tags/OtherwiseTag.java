/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/** 
* @author : pmqin
* @date   : 2016年7月22日 下午7:31:43 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class OtherwiseTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) getParent();
		if (!parent.isFlag()) {
			getJspBody().invoke(null);
		}
	}
}
