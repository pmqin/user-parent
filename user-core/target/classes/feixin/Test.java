package feixin;

import java.util.List;

public class Test {

	public Test() {
		//testInsertFeixin();
		//testUpdateFeixin();
		//testQueryFeixin();
		testDeleteDeixin();
	}
	
	private void testDeleteDeixin(){
		feixinJDO.deleteRecord(new Integer(5));
	}
	
	private void testInsertFeixin(){
		feixinJDO.insertRecord(new Integer(1), "13976523784", "jeffery", "goal");
		feixinJDO.insertRecord(new Integer(2), "13976523785", "jerry", "lin");
		feixinJDO.insertRecord(new Integer(3), "13976523786", "tina", "zhu");
		feixinJDO.insertRecord(new Integer(4), "13976523787", "sandra", "zhao");
		feixinJDO.insertRecord(new Integer(5), "13976523788", "medusa", "wang");
	}
	
	private void testUpdateFeixin(){
		//仅修改电话号码
		feixinJDO.updateRecord(new Integer(3), "18900000000", null, null);
	}
	
	private void testQueryFeixin(){
		FeixinQueryBean fqb=new FeixinQueryBean();
		fqb.setMobileNo("139");//电话号码模糊查询值
		fqb.setMobileNoLikeSuffix(true);//like 'xx%'
		fqb.setMobileNoDesc(true);//电话号码倒序排列
		List<Object> list=feixinJDO.queryRecord(fqb);
		Feixin f=null;
		for(int i=0;i<list.size();i++){
			f=(Feixin)list.get(i);
			System.out.println("ID=" + f.getId().toString() + 
					" |MobileNo=" + f.getMobileNo() +
					" |Name=" + f.getName() +
					" |Nickname=" + f.getNickname());
		}
	}

	public static void main(String[] args) {
		new Test();
	}
}