/**
 * 
 */
package pmqin.com.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

/** 
* @author : pmqin
* @date   : 2016年3月26日 下午5:46:10 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class DataStructureAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] list = { 66, 76, 7,2323,32,2334,55 };
		//SortClass.XianXinDelete(list, 1);
		for (int i : list) {
			System.out.println(i);
		}
		System.out.println(list[0]);
		System.out.println("复制的数组");
		
		
		List<Integer> list2=new ArrayList<>();
		list2.add(12);
		list2.add(123);
		list2.add(124);
		list2.add(125);
		list2.add(126);
		list2.add(127);
		list2.add(1245);
		//第一个是要复制的数组,第二个是源数组要复制的起始索引位置;,第三个是目的数组,四个是复制到目的数组的起始索引位置,最后一个是复制长度
		
		System.arraycopy(list2.toArray(), 2, list2.toArray(), 3, 4);
		//list[2]=987;填充位置
		for (Integer i : list2) {
			System.out.println(i);
		}

	}

}
