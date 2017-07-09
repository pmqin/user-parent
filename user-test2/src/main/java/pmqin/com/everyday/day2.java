package pmqin.com.everyday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day2 {
     /*
      * 在编译后所有的泛型类型都会做相应的转化，转换规则如下：
		1. List<String>、List<Integer>、List<T>擦除后的类型为List；
		2. List<String>[]擦除后的类型为List[]；
		3. List<? extends E>、List<? super E>擦除后的类型为List<E>；
		4. List<T extends Serializable & Cloneable>擦除后为List<Serializable>；
		Java编译后的字节码中没有泛型的任何信息，就是说一个泛型类和一个普通类在经过编译后都指向了同一个字节码，
		如Ques1103<T>类，编译后只有一份Ques1103.class类，不管是Ques1103<String>还是Ques1103<Integer>引用的都是同一字节码。
      */
	public void method01(String[] array){}    
    public void method01(Integer[] array){}   
    //public void method02(List<String> list){}
    public void method02(List<Integer> list){}
    
   
    
    private String num;

    public void setNum(String num){
    	num = num;  // 1局部變量自己玩,跟類的屬性無關
       // this.num = num;  // 2
    }

    public String getNum(){
        return num;
    }
    
    
}
