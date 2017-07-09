/**
 * 
 */
package pmqin.com.Generic;

import java.util.Set;

import org.apache.commons.collections.functors.NotNullPredicate;

/** 
* @author : pmqin
* @date   : 2016年4月21日 下午11:13:22 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class GenericDao<T> {

	
	public void add(T t)
	{}
	
	public T getName(int id) {
		return null;
	}
	
	public void deleteName(int id) {
		
	}
	
	public T updateName(T t) {
		return null;
	}
	
	public Set<T> findNameByCondittion(String str) {
		return null;
	}
	
	//泛型类里面是不能使用静态的方法的，如果想用就自己单独定义,其方法返回类型前面的类型是独立于类的泛型存在的。
	public static <E> void updateName2(E obj) {
		
	}
	

}
