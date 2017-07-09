package pmqin.com.test;

public class WarpAbstract {

	

	public abstract class Context implements Itest {
		
//		static {  内部内不能有静态区域
//			System.out.println("JVM会执行该类的静态代码段");
//		}
		public abstract int getAge();

		public void GetName() {
			System.out.println("GetName" + getAge() + AdressName());
		}
	}
	
	
	
	protected void setup(Context context) {
		System.out.println("abstractClass"+context.AdressName());
		context.GetName();
	}
	//对外提供
	 public void run(Context context)
	 {
		 setup(context);
	 }
	 
	 
	 //private static WarpAbstract.Context  context;
	 public static void main(String[] args) {
		 
		 WarpAbstract  warpAbstract=new WarpAbstract();
		 
		 warpAbstract.run(warpAbstract.new Context() {
			
			@Override
			public String AdressName() {
				// TODO Auto-generated method stub
				return "java的匿名类";
			}
			
			@Override
			public int getAge() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		 
		 
		 

		}
	

}
