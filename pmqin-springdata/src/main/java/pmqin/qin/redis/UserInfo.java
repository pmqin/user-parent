package pmqin.qin.redis;

public class UserInfo {
	 private Integer id;

	    private String username;

	    private Integer usernumber;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public Integer getUsernumber() {
	        return usernumber;
	    }

	    public void setUsernumber(Integer usernumber) {
	        this.usernumber = usernumber;
	    }
}
