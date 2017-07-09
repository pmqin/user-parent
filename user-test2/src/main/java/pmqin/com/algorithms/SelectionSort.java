/**
 * 
 */
package pmqin.com.algorithms;
/** 
* @author : pmqin
* @date   : 2016年8月29日 下午7:49:23 
* @version 1.0 
* @parameter  
*/
/**
 * @author pmqin
 *
 */
public class SelectionSort {

	// 分类 -------------- 内部比较排序
	// 数据结构 ---------- 数组
	// 最差时间复杂度 ---- O(n^2)
	// 最优时间复杂度 ---- O(n^2)
	// 平均时间复杂度 ---- O(n^2)
	// 所需辅助空间 ------ O(1)
	// 稳定性 ------------ 不稳定
	//选择排序也是一种简单直观的排序算法。它的工作原理很容易理解：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
	//然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
	public static void main(String[] args) {
		 int[] A = { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 }; // 从小到大选择排序
		 SelectionSort1(A);
	}
	
	private static void  SelectionSort1(int[] arry) {
		int n=arry.length;
		 int k, k2, min;
		 for (k = 0; k <= n-2; k++) {//// 已排序序列的末尾
			min=k;
			for (k2 = k+1; k2 <= n-1; k2++) {  // 未排序序列
				if (arry[k2]<arry[min]) {// 依次找出未排序序列中的最小值,存放到已排序序列的末尾
					min=k2;
				}
				
			}
			if (min!=k) {
				exchange(arry,min,k);// 该操作很有可能把稳定性打乱,所以选择排序是不稳定的排序算法
			}
			
		}
		 System.out.print("选择排序结果：");
		 for (int i = 0; i < arry.length; i++) {
			System.out.print(arry[i]+",");
		}
		
	}
	private static void exchange(int A[], int i, int j) {
		 int temp = A[i];
		    A[i] = A[j];
		    A[j] = temp;
	}
	

}
