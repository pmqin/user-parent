<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring3 MVC</title>
</head>
<body>
<h1> 默认情况下，作用域是单例模式 : ${message}</h1>
    <h2>当前时间:${date}</h2>
   <br> 
singleton — 单例模式，由IOC容器返回一个唯一的bean实例。 <br>
prototype — 原型模式，被请求时，每次返回一个新的bean实例。 <br>
request — 每个HTTP Request请求返回一个唯一的Bean实例。 <br>
session — 每个HTTP Session返回一个唯一的Bean实例。 <br>
globalSession — Http Session全局Bean实例。 <br>
   <br>
    
  <h2>多个xml配置文件整合</h2>

Spring-Common.xml位于common文件夹下
Spring-Connection.xml位于connection文件夹下
Spring-ModuleA.xml位于moduleA文件夹下

你可以在代码中加载以上3个xml配置文件

ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-Common.xml","Spring-Connection.xml","Spring-ModuleA.xml"});

但是这种方法不易组织并且不好维护，最好的方法是在一个单独的xml的配置文件中组织其他所有的xml配置文件。例如，可以创建一个Spring-All-Module.xml文件，然后将其他的xml配置文件导入到Spring-All-Module.xml中，就像下边这样，

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <import resource="common/Spring-Common.xml"/>
    <import resource="connection/Spring-Connection.xml"/>
    <import resource="moduleA/Spring-ModuleA.xml"/>
</beans>

现在，你可以在代码中加载一个单独的xml配置文件，如下：
ApplicationContext context =    new ClassPathXmlApplicationContext(Spring-All-Module.xml);

<h2>加载多个JavaConfig特性配置</h2>
假设有两个JavaConfig的配置：

CustomerConfig.java
SchedulerConfig.java

你需要管理多个JavaConfig配置的情况下，可以单独创建一个AppConfig.java，然后将其他的配置导入到AppConfig.java中，如下
AppConfig.java

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {

}

ApplicationContext context =　　new AnnotationConfigApplicationContext(AppConfig.class);

<br>
更多其他的Bean的基本用法：  http://www.cnblogs.com/leiOOlei/p/3532604.html#q1
</body>
</html>