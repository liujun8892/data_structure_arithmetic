package com.jack.tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * 模拟了合并排序
 */
public class MergeSort {



    public static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            //分
            //递归二分化为最小单位
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            //合
            merge(data,left,mid,right);
        }
    }

    public static void merge(int[] data,int left,int mid,int right){
        //定义一个临时的数组
        int[] temp = new int[data.length];

        //定义两个指针,记录要比较数,左边第一个
        int point1 = left;
        int point2 = mid+1;
        //定义一个临时的下标,记录插入temp数组的角标
        int local = left;

        //小的数插入临时数组的左边
        while (point1<=mid && point2 <=right){
            if (data[point1]<data[point2]){
                temp[local] = data[point1];
                point1++;
                local++;
            }else {
                temp[local] = data[point2];
                point2++;
                local++;
            }
        }

        //防止左边还有的数没有插入
        while (point1<=mid){
            temp[local++] = data[point1++];
        }

        //防止右边还有的数没有插入
        while (point2<=right){
            temp[local++] = data[point2++];
        }

        //把临时数组的值赋值给原数组
        if (right + 1 - left >= 0) System.arraycopy(temp, left, data, left, right + 1 - left);


    }

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 5, 63, 2, 4, 6, 9, 10,-1};
        mergeSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));

    }

}
