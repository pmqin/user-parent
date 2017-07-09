/**
 * 
 */
package pmqin.model;
/** 
* @author : pmqin
* @date   : 2016年1月30日 下午10:59:10 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class UserRole {

	
	public UserRole()
	{}
	/**
	 * @param id
	 * @param roleName
	 * @param adderName
	 */
	public UserRole(Integer id, String roleName, String adderName) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.adderName = adderName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAdderName() {
		return adderName;
	}

	public void setAdderName(String adderName) {
		this.adderName = adderName;
	}

	private Integer id;

	private String roleName;

	private String adderName;
}
