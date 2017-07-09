/**
 * 
 */
package pmiqn.com.cn;

/** 
* @author : pmqin
* @date   : 2016年6月11日 下午4:19:49 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class Originator {
	// 内部状态
	private String name;
	private String addrss;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrss() {
		return addrss;
	}
	public void setAddrss(String addrss) {
		this.addrss = addrss;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//创建一个备忘录
	public Memento CreateMemento()
	{
		return new Memento(BeanUtils.backupProp(this));
	}
	//恢复一个备忘录 
	public void RestoreMemento(Memento _mMemento)
	{
		BeanUtils.restoreProp(this, _mMemento.getStateMap());
	}
	@Override
	public String toString() {
		return "Originator [name=" + name + ", addrss=" + addrss + ", phone=" + phone + "]";
	}
	

}
