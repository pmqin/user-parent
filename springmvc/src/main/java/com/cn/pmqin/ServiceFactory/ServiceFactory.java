/**
 * 
 */
package com.cn.pmqin.ServiceFactory;

import com.cn.pmqin.IDao.IOutputGenerator;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午3:01:22 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */

public class ServiceFactory {
	
    IOutputGenerator outputGenerator;
    
	public void generateOutput(){
        this.outputGenerator.generateOutput();
    }
    
    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }
}
