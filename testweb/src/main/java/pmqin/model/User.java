/**
 * 
 */
package pmqin.model;
/** 
* @author : pmqin
* @date   : 2016年7月7日 下午8:06:03 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class User {
  
	public User()
	{}
	/** full constructor */ 
	public User(Integer id, String mobileNo, String userName, String adderName) {
		this.id = id;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.adderName = adderName;
	}

	private Integer id;

   private String userName;

	private String adderName;

	private String mobileNo;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdderName() {
		return adderName;
	}

	public void setAdderName(String adderName) {
		this.adderName = adderName;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", adderName=" + adderName + ", mobileNo=" + mobileNo + "]";
	}
}
