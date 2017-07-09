/**
 * 
 */
package pmiqn.com.cn;

import java.util.*;

/** 
* @author : pmqin
* @date   : 2016年6月11日 下午4:42:02 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class MultiCaretaker {
	// 容纳备忘录的容器
	private HashMap<String, Memento> memMap = new HashMap<String, Memento>();

	public Memento getMemento(String idx) {
		return memMap.get(idx);
	}

	public void setMemento(String idx, Memento memento) {
		this.memMap.put(idx, memento);
	}
}
