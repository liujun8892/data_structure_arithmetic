package com.jack.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSort {
    public static void main(String[] args) {
        //实现插入排序
        System.out.println("请您输入您将要输入几个数:");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrInput = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("请您输入第"+(i+1)+"个数:");
            arrInput[i] = sc.nextInt();
        }

        for (int i = 1; i < arrInput.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arrInput[j]<arrInput[j-1]){
                    arrInput[j] = arrInput[j]+arrInput[j-1];
                    arrInput[j-1]=arrInput[j]-arrInput[j-1];
                    arrInput[j]=arrInput[j]-arrInput[j-1];
                }else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arrInput));


    }

}
