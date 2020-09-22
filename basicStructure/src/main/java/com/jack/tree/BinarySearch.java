package com.jack.tree;

/**
 * 二分查找法
 */
public class BinarySearch {

	/**
	 * 查找x在有序数组的下标
	 * @param data 有序数组
	 * @param x	要查找的值
	 * @param low	数组的开始下标
	 * @param high	数组结束下标
	 * @return	x在数组中的下标，如未找到返回-1
	 */
	public static int binarySearch(int data[],int x,int low,int high){
		if(x < data[low] || x > data[high] || low > high) return -1;
		int mid = (low + high) /2;
		if(x < data[mid]){
			return binarySearch(data, x, low, mid - 1);
		}else if(x > data[mid]){
			return binarySearch(data, x, mid+1, high);
		}else return mid;
	}


	public static void main(String[] args) {

		int data[]={6,12,45,60,80};
		int i = binarySearch(data, data[2], 0, data.length-1);
		System.out.println(i);
	}
}
