/**
 * 
 */
package com.cn.pmqin.Model;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午1:46:35 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.cn.pmqin.IDao.IOutputGenerator;
import com.cn.pmqin.Imp.CsvOutputGenerator;
import com.cn.pmqin.Imp.JsonOutputGenerator;
import com.cn.pmqin.ServiceFactory.ServiceFactory;

public class App {
	private static ApplicationContext context;

	public static void main(String[] args) throws IOException {
		/* xml配置文件的方式 */
		context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj0 = (HelloWorld) context.getBean("helloBeanp");
		obj0.setName("xml配置文件的方式prototype — 原型模式");
		obj0.printHello();
		System.out.println("Message : " + obj0.getName());

		// retrieve it again
		HelloWorld obj10 = (HelloWorld) context.getBean("helloBeanp");
		System.out.println("Message : " + obj10.getName());

		// 服务依赖
		context = new ClassPathXmlApplicationContext(new String[] { "Spring-Output.xml" });
		ServiceFactory output = (ServiceFactory) context.getBean("OutputHelper");
		// output.setOutputGenerator(new
		// JsonOutputGenerator());//也可以指定实现,但是最好不要这样，本来就是配置为了方便，你写死是不合理的
		// 实现了松耦合，当需要输出改变时，不必修改任何代码.java文件，只要修改Spring-Output.xml文件<property
		// name="outputGenerator" ref="CsvOutputGenerator"
		// />中的ref值，就可以实现输出不同的内容，不修改代码就减少了出错的可能性
		output.generateOutput();

		/* 其实直接赋值也可以,注意此处完全“面向接口编程，而不是面向实现” */
		context = new ClassPathXmlApplicationContext("Spring-Output.xml");
		IOutputGenerator output2 = (IOutputGenerator) context.getBean("CsvOutputGenerator");
		IOutputGenerator output3 = context.getBean("CsvOutputGenerator", IOutputGenerator.class);
		System.out.println("Message output3 ");
		output3.generateOutput();

		/**
		 * AppConfig 使用 这里的spring的初始化采用的是类配置文件的方式，而不是xml配置文件的方式 given annotated
		 * class and automatically refreshing the context.
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 从spring容器的上下文中获得指定的bean
		HelloWorld obj = (HelloWorld) context.getBean("helloWorldBean");
		obj.setName("Spring 4.2.4");
		obj.printHello();

		// 验证一下对于配置文件方式创建的bean是不是单件 默认情况下，作用域是单例模式
		obj = (HelloWorld) context.getBean("helloWorldBean");
		obj.setCouter(100);

		obj = (HelloWorld) context.getBean("helloWorldBean");
		System.out.println(obj.getCouter()); // 100

		obj = (HelloWorld) context.getBean("helloWorldBean");
		System.out.println(obj.getCouter());

		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorldBean");
		System.out.println("验证单例:" + (obj1 == obj));

		// 服务依赖输出
		IOutputGenerator obj2 = (IOutputGenerator) context.getBean("CsvOutputGenerator");
		obj2.generateOutput();

		//如果配置文件放置在文件系统的路径下，则可以优先考虑使用FileSystemXmlApplicationContext实现类
		// ApplicationContext fileac = new
		// FileSystemXmlApplicationContext("SpringBeans.xml");
		// Person person=(Person)fileac.getBean("PersonBean");
		// System.out.println(person.toString());
		// ApplicationContext context = new
		// AnnotationConfigApplicationContext(AppConfig.class);
		//BeanFactoryTest
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("SpringBeans.xml");
		System.out.println(res.getURL());
		BeanFactory bf = new XmlBeanFactory(res);

		Person person = bf.getBean("PersonBean", Person.class);
		System.out.println(person.toString());

	}
}
