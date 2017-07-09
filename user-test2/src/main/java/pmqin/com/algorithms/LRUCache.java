package pmqin.com.algorithms;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.LRUMap;

import com.sun.xml.internal.ws.util.QNameMap;

//http://blog.csdn.net/buster2014/article/details/50085181
//末尾插法
public class LRUCache {

	private int theArray[];
	private int back; // 定义队尾
	private int currentSize; // 队列中存放元素个数
	private int maxSize = 4; // 队列中能存放元素的个数

	public static void main(String[] args) {
		LRUCache lru = new LRUCache();
		int a[] = { 4, 7, 0, 7, 1, 0, 1, 2, 1, 2, 6 };
		lru.queue(a);
		
		
		LRUMap lruMap = new LRUMap(2);  
	    lruMap.put("a1", "1");  
	    lruMap.put("a2", "2");  
	    lruMap.get("a2");//mark as recentused  
	    lruMap.put("a3", "3");  
	    System.out.println("lruMap:"+lruMap);  
	    
	    
	    LinkedHashMap<String, String>  hashMapData=new LinkedHashMap<>();
	    hashMapData.put("sadasd", "dasd");
	    hashMapData.put("sadasd1", "das1d");
	    hashMapData.put("sadasd", "dasd");
	    Iterator iter = hashMapData.entrySet().iterator();
	    int index = 0;
        while (iter.hasNext()) {
        	Map.Entry entry = (Map.Entry) iter.next();
           //System.out.println(index++);
           System.out.println(entry.getValue());
        }
		
	}

	public LRUCache() {
		theArray = new int[maxSize];
		back = 0;
		currentSize = 0;
	}

	public void queue(int a[]) {
		for (int i = 0; i < a.length; i++) {
			enQueue(a[i]);
		}
	}

	public void enQueue(int x) { // 入队
		beUsed(x); // 先判断是否已存在该页号，若存在，删除
		if (currentSize < maxSize) {
			theArray[back] = x;
			back++;
			currentSize++;
		} else if (currentSize == maxSize) { // 满了
			for (int i = 0; i < maxSize - 1; i++) {
				theArray[i] = theArray[i + 1];
			}
			theArray[maxSize - 1] = x;
		}
		for (int i = 0; i < currentSize; i++) {
			System.out.print(theArray[i]);
		}
		System.out.println();
	}

	public void beUsed(int x) { // 判断是否已存在,若存在，删除已有的
		for (int i = 0; i < currentSize; i++) {
			if (theArray[i] == x) {
				for (int j = i; j < currentSize - 1; j++) {
					theArray[j] = theArray[j + 1];
				}
				currentSize--;
				back--;
			}
		}
	}

}
