/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/** 
* @author : pmqin
* @date   : 2016年7月22日 下午7:19:52 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class WhenTag extends SimpleTagSupport {
	private boolean test;

	// tld文件中的属性必须要有对应的set方法，否则报错
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) getParent();
		if (!parent.isFlag()) {
			if (test) {
				parent.setFlag(true);
				getJspBody().invoke(null);
			}
		}
	}
}
