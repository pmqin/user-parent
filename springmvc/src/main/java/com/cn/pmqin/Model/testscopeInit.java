package com.cn.pmqin.Model;

import java.io.IOException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class testscopeInit {
	private static AbstractApplicationContext  context;
	public static void main(String[] args) throws IOException {
		
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("SpringBeans.xml");
		System.out.println(res.getURL());
		BeanFactory bf = new XmlBeanFactory(res);
		System.out.println("jkhkjhjk");
       //Person person = bf.getBean("PersonBean", Person.class);
//		System.out.println(person.toString());
		
		
		context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		context.close();
	}

}
