/**
 * 
 */
package com.cn.pmqin.Imp;

import com.cn.pmqin.IDao.IOutputGenerator;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午2:53:34 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class JsonOutputGenerator implements IOutputGenerator {

	/* (non-Javadoc)
	 * @see com.cn.pmqin.IDao.IOutputGenerator#generateOutput()
	 */
	@Override
	public void generateOutput() {
		System.out.println("输出JsonOutputGenerator生成  Output......");
	}

}
