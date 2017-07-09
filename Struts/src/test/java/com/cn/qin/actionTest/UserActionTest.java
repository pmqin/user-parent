/**
 * 
 */
package com.cn.qin.actionTest;

import java.lang.reflect.Proxy;

import org.apache.struts2.util.StrutsTestCaseHelper;
import org.junit.Test;
import org.junit.runner.Request;
import static org.junit.Assert.*;

import com.opensymphony.xwork2.ActionProxy;

/** 
* @author : pmqin
* @date   : 2016年2月28日 上午12:52:27 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserActionTest extends StrutsTestCaseHelper {

	@Test
	public void testCaseExecute() {
		System.out.println("sdffsdfsdf");
		// ActionProxy proxy=null;
		/*assertEquals(true, context.isPassValidate());

		assertEquals(ProductMaintainCode.SUCCESS, context.getErrCode());
		assertThat("good", allOf(equalTo("good"), startsWith("good")));

		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));

		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));

		assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));

		assertThat(new Object(), not(sameInstance(new Object())));*/
	}

	// 测试异常
	@Test(expected = NullPointerException.class)

	public void testLengthArray() {

		StringBuffer hwd = new StringBuffer();

		// hwd.lengthArray(null);

	}
}
