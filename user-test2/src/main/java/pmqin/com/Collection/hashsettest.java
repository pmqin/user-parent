/**
 * 
 */
package pmqin.com.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/** 
* @author : pmqin
* @date   : 2016年7月30日 下午6:00:28 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class hashsettest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashSet<Student> set = new HashSet<>();
		Student stu = new Student(123, "Tom");
		set.add(stu);
		set.add(new Student(456, "Jerry"));
		set.add(new Student(123, "Lily"));
		Iterator<Student> iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getStuNum() + " --- " + student.getName());
		}
		//如果不参与比较的对象，就应该重写hashcode和equel的时候去掉
//		for (int i = 0; i < set.size(); i++) {
//			
//		}
		
	}

}
