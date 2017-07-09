/**
 * 
 */
package pmiqn.com.Multithread;
/** 
* @author : pmqin
* @date   : 2016年7月26日 下午9:51:15 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class ThreadDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		class Person{
            public String name;
            private String gender;
            public void set(String name,String gender){
                this.name =name;
                this.gender =gender;
            }
            public void get(){
                System.out.println(this.name+"...."+this.gender);
            }
        }
		
		final Person p =new Person();
        new Thread(new Runnable(){
            public void run(){
                int x=0;
                while(true){
                    if(x==0){
                        p.set("张三", "男");
                    }else{
                        p.set("lili", "nv");
                    }
                    x=(x+1)%2;
                }
            }
        }).start();
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    p.get();
                }
            }
        }).start();
	}

}
