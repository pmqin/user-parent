/**
 * 
 */
package pmqin.com.io;

import java.io.*;
import java.util.*;


/** 
* @author : pmqin
* @date   : 2016年4月20日 下午10:01:24 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Filetest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties kvs = getPro();
		System.out.println(kvs.containsKey("driver"));

		Iterator<Object> it = kvs.keySet().iterator();
		// Iterator<String> it=kvs.stringPropertyNames().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key + ":" + kvs.getProperty(key));
		}
		System.out.println(kvs.getProperty("driver"));
		System.out.println(kvs.getProperty("fdf", "设置默认值"));

		// 保存属性到b.properties文件
		Properties prop = new Properties();
		FileOutputStream oFile = new FileOutputStream("b.properties", false);// true表示追加打开
		// pro.store(oFile,
		// "Comment");//如果comments不为空，保存后的属性文件第一行会是#comments,表示注释信息；如果为空则没有注释信息。注释信息后面是属性文件的当前保存时间信息。
		prop.setProperty("phone", "10086");
		prop.store(oFile, "The New properties file");
		oFile.close();

		ArrayList<String> places = new ArrayList<String>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
		Iterator<String> it2 = places.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		List<String> places2 = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
		//List<String> strings = new ArrayList<String>(asList("foo", "bar", "baz"));
		for (String item : places) {
			System.out.println(item);
		}
		
		
	}

	public static <T> ArrayList<T> createArrayList(T... elements) {
		ArrayList<T> list = new ArrayList<T>();
		for (T element : elements) {
			list.add(element);
		}
		return list;
	}

	public static Properties getPro() throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		// pro需要InputStream对象进行读取文件，而获取InputStream有多种方法：
		// 1、通过绝对路径:InputStream is=new FileInputStream(filePath);
		// 2、通过Class.getResourceAsStream(path);
		// 3、通过ClassLoader.getResourceAsStream(path);
		// 前面路径不要加“/” 默认则是从ClassPath根下获取
		// InputStream is1 =
		// test.class.getClassLoader().getResourceAsStream("com/cn/pmqin/db.properties");
		InputStream is = Filetest.class.getClassLoader().getResourceAsStream("db.properties");
		// path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取
		// InputStream is = test.class.getResourceAsStream("/a.properties");
		// InputStream DD= ClassLoader.getSystemResourceAsStream(
		// "xx.properties" );
		File f = new File("D:\\InstallSoft\\V2\\workspace\\myTest\\src\\db.properties");
		if (f.exists()) {
			pro.load(new FileInputStream(f));
			// pro.load(is);
		} else {
			pro.setProperty("apple", "Reflect.Apple");
			pro.setProperty("orange", "Reflect.Orange");
			pro.store(new FileOutputStream(f, true), "FRUIT CLASS");
		}
		is.close();
		return pro;
	}

}
