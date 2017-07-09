package feixin;

import hibernatetool.JDO;

import java.util.List;

public class feixinJDO {

	public feixinJDO(){}
	
	/**
	 * 
	 * @param id
	 * @param mobileNo
	 * @param name
	 * @param nickname
	 * @return
	 */
	public static Feixin insertRecord(Integer id,String mobileNo,String name,String nickname){
		Feixin f=new Feixin();
		f.setId(id);
		f.setMobileNo(mobileNo);
		f.setName(name);
		f.setNickname(nickname);
		JDO.insert(f);
		return f;
	}
	
	/**
	 * 
	 * @param id 主键
	 * @param mobileNo
	 * @param name
	 * @param nickname
	 * @return
	 */
	public static Feixin updateRecord(Integer id,String mobileNo,String name,String nickname){
		String hqlWithKey="select new Feixin(f.id,f.mobileNo,f.name,f.nickname) from Feixin as f where f.id=" + id.toString();
		Feixin record=(Feixin)JDO.getRecorderByKey(hqlWithKey,true);//查询使用二级缓存
		if(mobileNo!=null) record.setMobileNo(mobileNo);//不为空则修改mobileNo字段
		if(name!=null) record.setName(name);//不为空则修改name字段
		if(nickname!=null) record.setNickname(nickname);//不为空则修改name字段
		JDO.update(record);
		return record;
	}
	
	/**
	 * 
	 * @param fqb
	 * @return
	 */
	public static List<Object> queryRecord(FeixinQueryBean fqb){
		String hql="select new Feixin(f.id,f.mobileNo,f.name,f.nickname) from Feixin as f where 1=1";
		if(fqb!=null){
			if(fqb.getMobileNo()!=null){
				if(fqb.isMobileNoLikePrefix()==true) hql+=" and f.mobileNo like '%" + fqb.getMobileNo() + "'";
				else if(fqb.isMobileNoLikeSuffix()==true) hql+=" and f.mobileNo like '" + fqb.getMobileNo() + "%'";
				else if(fqb.isMobileNoLikeMiddle()==true) hql+=" and f.mobileNo like '%" + fqb.getMobileNo() + "%'";
			}else if(fqb.getName()!=null){
				if(fqb.isMobileNoLikePrefix()==true) hql+=" and f.name like '%" + fqb.getName() + "'";
				else if(fqb.isNameLikeSuffix()==true) hql+=" and f.name like '" + fqb.getName() + "%'";
				else if(fqb.isNameLikeMiddle()==true) hql+=" and f.name like '%" + fqb.getName() + "%'";
			}else if(fqb.getNickname()!=null){
				if(fqb.isNicknameLikePrefix()==true) hql+=" and f.nickname like '%" + fqb.getNickname() + "'";
				else if(fqb.isNicknameLikeSuffix()==true) hql+=" and f.nickname like '" + fqb.getNickname() + "%'";
				else if(fqb.isNicknameLikeMiddle()==true) hql+=" and f.nickname like '%" + fqb.getNickname() + "%'";
			}
			if(fqb.isMobileNoDesc()!=false || fqb.isNameDesc()!=false || fqb.isNicknameDesc()!=false){
				hql+=" order by";
				if(fqb.isMobileNoDesc()==true) hql+=" f.mobileNo DESC,";
				if(fqb.isNameDesc()==true) hql+=" f.name DESC,";
				if(fqb.isNicknameDesc()==true) hql+=" f.nickname DESC,";
				hql=hql.substring(0,hql.length()-1);
			}
		}
		System.out.println("hql=" + hql);
		return JDO.getRecorderList(hql, fqb.getStartRecord(), fqb.getMaxRecords(), true);
	}
	
	/**
	 * 
	 * @param ID 主键
	 */
	public static void deleteRecord(Integer ID){
		String hql="select new Feixin(f.id,f.mobileNo,f.name,f.nickname) from Feixin as f where f.id='"
				+ ID.toString() + "'";
		Feixin record=(Feixin)JDO.getRecorderByKey(hql,true);
		JDO.delete(record);
	}
}