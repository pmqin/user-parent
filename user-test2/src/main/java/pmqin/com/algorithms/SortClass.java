/**
 * 
 */
package pmqin.com.algorithms;

import java.util.Iterator;
import java.util.Stack;

/** 
* @author : pmqin
* @date   : 2016年3月28日 下午11:35:59 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public final class SortClass {

	/* 冒泡排序 */
	public static void BubbleDescSort(int[] arr) {

		int len = arr.length - 1;
		int temp = 0;
		while (len > 0) {
			for (int j = 0; j < len; j++) {
				if (arr[j] < arr[j + 1]) {

					// temp=demo4[j+1];
					// demo4[j+1]=demo4[j];
					// demo4[j+1]=temp;

					arr[j] = arr[j] + arr[j + 1];
					arr[j + 1] = arr[j] - arr[j + 1];
					arr[j] = arr[j] - arr[j + 1];
				}
			}
			len--;
		}

		
		/*
		 * 方法二 for (int i = 0; i < arr.length - 1; i++) {
		 * //将大的数字移到数组的arr.Length-1-i for (int j = 0; j < arr.Length - 1 - i;
		 * j++) { if (arr[j] > arr[j + 1]) { temp = arr[j + 1]; arr[j + 1] =
		 * arr[j]; arr[j] = temp; } }
		 */
		
		/*
		 * 方法二 for (int i = 1; i < arr.length; i++) {
		 * //将大的数字移到数组的arr.Length-1-i for (int j = 0; j < arr.Length  - i;
		 * j++) { if (arr[j] > arr[j + 1]) { temp = arr[j + 1]; arr[j + 1] =
		 * arr[j]; arr[j] = temp; } }
		 */

	}

	/* 冒泡排序 */
	public static void BubbleAscSort(int[] a) {

		int temp = 0;
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; ++j) {
				if (a[j + 1] < a[j]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	// 线性表的插入元素 0【n】
	public static void XianXinInsert(int[] a, int index, int insertValue) {
		if (index>a.length||index<0) {
		
		}
		if (index>=0&&index<a.length) {
			for(int i=index;i<a.length;i++)
			{
				a[index+1]=a[index];
			}
			a[index]=insertValue;//插入元素赋值
		}
		
	}
	
	public static void XianXinDelete(int[] a, int index) {
		if (index>a.length||index<0) {
		
		}
		if (index>=0&&index<a.length) {
			for(int i=index;i<a.length;i++)
			{
				a[index]=a[index+1];
			}
			
		}
		
	}

}
