package com.jack.sort;

import java.util.Arrays;

public class QSort {

    public static void qSort(int[] arr,int left,int right){
        int ll = left;
        int rr = right;
        int base = arr[left];

        //从后往前找,比基准数小的就交换位置
        while (ll<rr && base<=arr[rr]){
            rr--;
        }

        if (ll<rr){
            int temp = base;
            arr[ll] = arr[rr];
            arr[rr]=temp;
            //刚换过一次位置,可以少一次计算
            ll++;
        }

        //再从前面往后面找,比基准数大的就交换位置
        while (ll<rr && base>=arr[ll]){
            ll++;
        }

        if (ll<rr){
            int temp = base;
            arr[rr] =arr[ll];
            arr[ll]=temp;
            rr--;
        }

        //递归,剩余分组快排
        if (ll>left){
            qSort(arr,left,ll-1);
        }

        if (rr<right){
            qSort(arr,ll+1,right);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,4,6,7,2,1,5,9,8};
        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
