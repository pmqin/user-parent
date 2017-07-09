/**
 * 
 */
package com.cn.pmqin.controller;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cn.pmqin.Model.Person;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午1:01:16 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
@Controller()
//@RequestMapping("/rest") //也可以去掉
public class HelloController {

	private static final Log logger = LogFactory.getLog(HelloController.class);

	 @CrossOrigin  //可以让你以一种弹性的方式指定哪些跨域请求是被授权的 http://www.cnblogs.com/larryzeal/p/6213012.html
	// @RequestMapping(value="/qin",method = RequestMethod.GET)
	@RequestMapping(value = { "/pmqin", "qin" }) // 以上“/pmqin”和“/qin”映射到同一个函数处理。
	public ModelAndView printWelcome() {

	    logger.info("HelloControllerinfo");
        logger.debug("HelloControllerdebug");
        logger.error("HelloControllererror");
        logger.fatal("HelloControllerdebugfatal");
	    
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Spring3 MVC 例子");
		model.addObject("date", new SimpleDateFormat("yyyy年MM月dd日").format(new java.util.Date()));

		model.setViewName("hello");
		//高到低分别是ERROR、WARN、INFO、DEBUG。通过在这里定义的级别，您可以控制到应用程序中相应级别的日志信息的开关。
		//比如在这里定义了INFO级别，则应用程序中所有DEBUG级别的日志信息将不被打印出来。程序会打印高于或等于所设置级别的日志，设置的日志等级越高，
		//打印出来的日志就越少。如果设置级别为INFO，
		//则优先级高于等于INFO级别（如：INFO、WARN、ERROR）的日志信息将可以被输出,小于该级别的如DEBUG将不会被输出。
		
		
		return model;
	}

	// 访问user/123/lei路径时，执行以上方法，其中，参数id=123，name=lei 如何不同文件夹里面的jsp文件呢
	@RequestMapping(value = "user/{id}/{name}", method = RequestMethod.GET)
	public String printMessage1(@PathVariable String id, @PathVariable String name, ModelMap model) {

		System.out.println(id);
		System.out.println(name);
		model.addAttribute("message", name);
		return "users";
	}

	@RequestMapping(params = ("method=list"))
	public ModelAndView listAll(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		// ModelAndView mv = new ModelAndView("/views/show.jsp");

		model.setViewName("hello");
		return model;
	}

	@RequestMapping("/person1")
	public String toPerson(Person p) {
		System.out.println(p.getName() + " " + p.getAge());
		return "hello";
	}

	@RequestMapping("/date")
	public String date(Date date) {
		System.out.println(date);
		return "test";
	}

	// At the time of initialization,convert the type "String" to type "date"
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping("/show")
	public String showPerson(Map<String, Object> map) {
		Person p = new Person();
		map.put("p", p);
		p.setAge(20);
		p.setName("jayjay");
		return "show";
	}

	@RequestMapping("/getPerson") // getPerson?name=2
	public void getPerson(String name, PrintWriter pw) {
		pw.write("hello," + name);
	}

	@RequestMapping("/name")
	public String sayHello() {
		return "name";
	}

	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:qin";// 这个是rest名称
	}

	@RequestMapping("/test2")
	public ModelAndView uploadfile() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Spring3 MVC uploadfile 例子");
		model.setViewName("uploadfile");
		return model;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req) throws Exception {
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		String fileName = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		FileOutputStream fos = new FileOutputStream(req.getSession().getServletContext().getRealPath("/") + "upload/"
				+ sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.')));
		fos.write(file.getBytes());
		fos.flush();
		fos.close();

		return "uploadfile";
	}

	// 使用@RequestParam注解指定参数的name
	@RequestMapping(value = "/param")
	public String testRequestParam(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {
		System.out.println(id + " " + name);
		return "/hello";
	}

	// RESTFul风格的SringMVC
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Integer id) {
		System.out.println("get" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public String post(@PathVariable("id") Integer id) {
		System.out.println("post" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public String put(@PathVariable("id") Integer id) {
		System.out.println("put" + id);
		return "/hello";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		System.out.println("delete" + id);
		return "/hello";
	}
	
	//返回json格式的字符串
	
    @RequestMapping("/user")
    @ResponseBody
    public  Person get(){
		Person u = new Person();
        u.setAge(2);
        u.setName("jayjay");
        u.setAddress("hgfhdfhdfhf");
        return u;
    }
	//异常的处理
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception ex){
	    ModelAndView mv = new ModelAndView("error");
	    mv.addObject("exception", ex);
	    System.out.println("in testExceptionHandler");
	    return mv;
	}
	    
	@RequestMapping("/error")
	public String error(){
	    int i = 5/0;
	    return "hello";
	}
	
	//更多 http://www.admin10000.com/document/6436.html
	

}
