/**
 * 
 */
package com.cn.pmqin.Model;
/** 
* @author : pmqin
* @date   : 2016年3月11日 下午2:02:48 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cn.pmqin.IDao.IOutputGenerator;
import com.cn.pmqin.Imp.CsvOutputGenerator;

@Configuration  //通过使用注释@Configuration 告诉Spring，这个Class是Spring的核心配置文件，并且通过使用注释@Bean定义bean，不需要xml配置了
public class AppConfig {
	
	
	
	@Bean(name="helloWorldBean")//表示外面直接可以使用这个bean，不需要xml配置了 
    public HelloWorld helloWorldService() {
        return new HelloWorld();
    }
	
	//用JavaConfig特性配置
	@Bean(name="CsvOutputGenerator")
    public IOutputGenerator OutputGenerator() {
        return new CsvOutputGenerator();
    }
	
}
