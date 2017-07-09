/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/** 
* @author : pmqin
* @date   : 2016年7月22日 下午7:18:09 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ChooseTag extends SimpleTagSupport {
	private boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
}
