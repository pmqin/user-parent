/**
 * 
 */
package pmqin.com.algorithms;

import java.util.*;
import java.util.Map.Entry;

/** 
* @author : pmqin
* @date   : 2016年9月11日 下午4:50:02 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin  http://www.cnblogs.com/lzrabbit/p/3734850.html
 *
 */
public class LRUCache1<K, V> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("===========================LRU 链表实现===========================");
		LRUCache1<Integer, String> lru = new LRUCache1(5);
		lru.put(1, "11");
		lru.put(2, "11");
		lru.put(3, "11");
		lru.put(4, "11");
		lru.put(5, "11");
		System.out.println(lru.toString());
		lru.put(6, "66");
		lru.get(2);
		lru.put(7, "77");
		lru.get(4);
		System.out.println(lru.toString());
		System.out.println();
	}

	private final int MAX_CACHE_SIZE;
	private Entry first;
	private Entry last;

	private HashMap<K, Entry<K, V>> hashMap;

	public LRUCache1(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		hashMap = new HashMap<K, Entry<K, V>>();
	}

	public void put(K key, V value) {
		Entry entry = getEntry(key);
		if (entry == null) {
			if (hashMap.size() >= MAX_CACHE_SIZE) {
				hashMap.remove(last.key);
				removeLast();
			}
			entry = new Entry();
			entry.key = key;
		}
		entry.value = value;
		moveToFirst(entry);
		hashMap.put(key, entry);
	}

	public V get(K key) {
		Entry<K, V> entry = getEntry(key);
		if (entry == null)
			return null;
		moveToFirst(entry);
		return entry.value;
	}

	public void remove(K key) {
		Entry entry = getEntry(key);
		if (entry != null) {
			if (entry.pre != null)
				entry.pre.next = entry.next;
			if (entry.next != null)
				entry.next.pre = entry.pre;
			if (entry == first)
				first = entry.next;
			if (entry == last)
				last = entry.pre;
		}
		hashMap.remove(key);
	}

	private void moveToFirst(Entry entry) {
		if (entry == first)
			return;
		if (entry.pre != null)
			entry.pre.next = entry.next;
		if (entry.next != null)
			entry.next.pre = entry.pre;
		if (entry == last)
			last = last.pre;

		if (first == null || last == null) {
			first = last = entry;
			return;
		}

		entry.next = first;
		first.pre = entry;
		first = entry;
		entry.pre = null;
	}

	private void removeLast() {
		if (last != null) {
			last = last.pre;
			if (last == null)
				first = null;
			else
				last.next = null;
		}
	}

	private Entry<K, V> getEntry(K key) {
		return hashMap.get(key);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Entry entry = first;
		while (entry != null) {
			sb.append(String.format("%s:%s ", entry.key, entry.value));
			entry = entry.next;
		}
		return sb.toString();
	}

	class Entry<K, V> {
		public Entry pre;
		public Entry next;
		public K key;
		public V value;
	}

}
