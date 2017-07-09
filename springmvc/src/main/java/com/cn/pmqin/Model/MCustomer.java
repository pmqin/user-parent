/**
 * 
 */
package com.cn.pmqin.Model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/** 
* @author : pmqin
* @date   : 2016年3月11日 下午7:01:52 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class MCustomer {
	private List<Object> lists;
	private Set<Object> sets;
	private Map<Object, Object> maps;
	private Properties pros;
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public Set<Object> getSets() {
		return sets;
	}
	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}
	public Map<Object, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<Object, Object> maps) {
		this.maps = maps;
	}
	public Properties getPros() {
		return pros;
	}
	public void setPros(Properties pros) {
		this.pros = pros;
	}
	
}
