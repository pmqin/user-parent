package feixin;

public class FeixinQueryBean {

	private String mobileNo=null;
	public String getMobileNo(){return mobileNo;}
	public void setMobileNo(String mobileNo){this.mobileNo = mobileNo;}
	
	private String name=null;
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	
	private String nickname=null;
	public String getNickname(){return nickname;}
	public void setNickname(String nickname){this.nickname = nickname;}
	
	private boolean mobileNoLikeSuffix=false;//电话号码模糊查询后缀'xx%'
	public boolean isMobileNoLikeSuffix(){return mobileNoLikeSuffix;}
	public void setMobileNoLikeSuffix(boolean mobileNoLikeSuffix){this.mobileNoLikeSuffix = mobileNoLikeSuffix;}
	
	private boolean nameLikeSuffix=false;//姓名模糊查询后缀'xx%'
	public boolean isNameLikeSuffix(){return nameLikeSuffix;}
	public void setNameLikeSuffix(boolean nameLikeSuffix){this.nameLikeSuffix = nameLikeSuffix;}
	
	private boolean nicknameLikeSuffix=false;//别名模糊查询后缀'xx%'
	public boolean isNicknameLikeSuffix(){return nicknameLikeSuffix;}
	public void setNicknameLikeSuffix(boolean nicknameLikeSuffix){this.nicknameLikeSuffix = nicknameLikeSuffix;}
	
	private boolean mobileNoLikePrefix=false;//电话号码模糊查询前缀'%xx'
	public boolean isMobileNoLikePrefix(){return mobileNoLikePrefix;}
	public void setMobileNoLikePrefix(boolean mobileNoLikePrefix){this.mobileNoLikePrefix = mobileNoLikePrefix;}
	
	private boolean nameLikePrefix=false;//电话号码模糊查询前缀'%xx'
	public boolean isNameLikePrefix(){return nameLikePrefix;}
	public void setNameLikePrefix(boolean nameLikePrefix){this.nameLikePrefix = nameLikePrefix;}
	
	private boolean nicknameLikePrefix=false;//电话号码模糊查询前缀'%xx'
	public boolean isNicknameLikePrefix(){return nicknameLikePrefix;}
	public void setNicknameLikePrefix(boolean nicknameLikePrefix){this.nicknameLikePrefix = nicknameLikePrefix;}
	
	private boolean mobileNoLikeMiddle=false;//电话号码模糊查询'%xx%'
	public boolean isMobileNoLikeMiddle(){return mobileNoLikeMiddle;}
	public void setMobileNoLikeMiddle(boolean mobileNoLikeMiddle){this.mobileNoLikeMiddle = mobileNoLikeMiddle;}
	
	private boolean nameLikeMiddle=false;//电话号码模糊查询'%xx%'
	public boolean isNameLikeMiddle(){return nameLikeMiddle;}
	public void setNameLikeMiddle(boolean nameLikeMiddle){this.nameLikeMiddle = nameLikeMiddle;}
	
	private boolean nicknameLikeMiddle=false;//电话号码模糊查询'%xx%'
	public boolean isNicknameLikeMiddle(){return nicknameLikeMiddle;}
	public void setNicknameLikeMiddle(boolean nicknameLikeMiddle){this.nicknameLikeMiddle = nicknameLikeMiddle;}

	private boolean mobileNoDesc=false;//电话号码倒序排列
	public boolean isMobileNoDesc(){return mobileNoDesc;}
	public void setMobileNoDesc(boolean mobileNoDesc){this.mobileNoDesc = mobileNoDesc;}
	
	private boolean nameDesc=false;//名字倒序排列
	public boolean isNameDesc(){return nameDesc;}
	public void setNameDesc(boolean nameDesc){this.nameDesc = nameDesc;}
	
	private boolean nicknameDesc=false;//别名倒序排序
	public boolean isNicknameDesc(){return nicknameDesc;}
	public void setNicknameDesc(boolean nicknameDesc){this.nicknameDesc = nicknameDesc;}
	
	private Integer startRecord=null;//起始分页
	public Integer getStartRecord(){return startRecord;}
	public void setStartRecord(Integer startRecord){this.startRecord = startRecord;}
	
	private Integer maxRecords=null;//最大记录条数
	public Integer getMaxRecords(){return maxRecords;}
	public void setMaxRecords(Integer maxRecords){this.maxRecords = maxRecords;}
	
	public FeixinQueryBean(){}
}