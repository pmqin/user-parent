/**
 * 
 */
package pmqin.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签是否执行
public class simpletag1 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		//设置标签体内容。标签体内容封装到JspFragment对象 中，然后传入JspFragment对象
		JspFragment jFragment = this.getJspBody();
		for (int i = 0; i < 5; i++) {
			//当参数为null时等价于 jspBody.invoke(getJspContext().getOut());
			jFragment.invoke(null);//这个不写就是不返回内容
		}
	}

}
