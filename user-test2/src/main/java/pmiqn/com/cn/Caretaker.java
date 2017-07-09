/**
 * 
 */
package pmiqn.com.cn;

/** 
* @author : pmqin
* @date   : 2016年6月11日 下午4:30:59 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Caretaker {
	// 发起人对象
	private Memento originator;

	public Memento getMemento() {
		return originator;
	}

	public void setMemento(Memento originator) {
		this.originator = originator;
	}
}
