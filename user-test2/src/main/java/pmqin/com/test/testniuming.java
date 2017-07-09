package pmqin.com.test;

import java.io.Console;

public class testniuming {

	public static void main(String[] args) {
		
		testniuming testniuming=new testniuming();
		String teString=testniuming.getName(new LockCallBack<String>() {

			@Override
			public String load(String s) {
				// TODO Auto-generated method stub
				return s;
			}

			
			
		}, "test");
		System.out.println(teString);

	}
	
	public <T> T getName(LockCallBack<T> load,String parms) {
		return load.load(parms);
	}

}
