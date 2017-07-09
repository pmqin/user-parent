/**
 * 
 */
package pmiqn.com.cn;

import java.util.*;

/** 
* @author : pmqin
* @date   : 2016年6月11日 下午4:22:31 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Memento {
	// 接受HashMap作为状态
	private HashMap<String, Object> stateMap;

	// 接受一个对象，建立一个备份
	public Memento(HashMap<String, Object> map) {
		this.stateMap = map;
	}

	public HashMap<String, Object> getStateMap() {
		return stateMap;
	}

	public void setStateMap(HashMap<String, Object> stateMap) {
		this.stateMap = stateMap;
	}
}
