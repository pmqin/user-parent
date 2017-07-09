/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签余下的JSP不执行
public class simpletag3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		throw new SkipPageException();
	}

}
