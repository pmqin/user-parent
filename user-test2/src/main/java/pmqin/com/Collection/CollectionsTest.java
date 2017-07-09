package pmqin.com.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class CollectionsTest {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>() {
			{
				add(0);
				add(-1);
			}
		};
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(2, 4, -9));
//http://blog.csdn.net/liyuming0000/article/details/49488607
		//Collections.addAll()或者是ArrayList.addAll()。在需添加元素比较少的情况下，并在List的size在万级以上时，一般建议Collections.addAll()，但当List的size较小时，两种方法没有什么区别，甚至ArrayList.addAll()更好。
		list1.addAll(list2);
		System.out.println(list1);
		list2.set(0, 100000);
		System.out.println(list1);// 深复制
		System.out.println();
		 //功能性展示  
        Collections.addAll(list2, 34, 67, 78);  
        System.out.println(list2);  
        list2.addAll(Arrays.asList(34, 67, 78));  
        System.out.println(list2);  
        System.out.println();  
      //性能展示  
        System.out.println("添加元素---------------------------\n");  
        for(int size = 1; size < 10; size++) {  
            long time = System.nanoTime();  
            List<Integer> list3 = new ArrayList<Integer>();  
            for(int i = 0; i < size; i++) {  
                list3.addAll(Arrays.asList(1, 45, 34, 456, 1212, -6, 43, 55));  
            }  
            System.out.println("ArrayList.addAll()@size = " + size + "\ntime:" + (System.nanoTime() - time));  
              
            time = System.nanoTime();  
            List<Integer> list4 = new ArrayList<Integer>();  
            for(int i = 0; i < size; i++) {  
                Collections.addAll(list4, 1, 45, 34, 456, 1212, -6, 43, 55);  
            }  
            System.out.println("Collections.addAll()@size = " + size + "\ntime:" + (System.nanoTime() - time) + "\n");  
        }  
        System.gc();  
        
        
        HashSet<Integer> set1 = new HashSet<Integer>();  
        HashSet<Integer> set2 = new HashSet<Integer>() {{add(5);}};  
          
        Collections.addAll(set1, 2, 4, 6, 7);  
        System.out.println(set1);  
          
        set1.addAll(set2);  
        System.out.println(set1);  
          
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(){{put(1, 5);}};  
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(){{put(3, 4);}};  
          
        map1.putAll(map2);  
        System.out.println(map1);  
        
	}

}
