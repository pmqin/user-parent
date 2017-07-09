package feixin;

/**
 * Feixin entity. @author MyEclipse Persistence Tools
 */

public class Feixin implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mobileNo;
	private String name;
	private String nickname;

	// Constructors

	/** default constructor */
	public Feixin() {
	}

	/** minimal constructor */
	public Feixin(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Feixin(Integer id, String mobileNo, String name, String nickname) {
		this.id = id;
		this.mobileNo = mobileNo;
		this.name = name;
		this.nickname = nickname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}