package com.jack.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        //实现冒泡排序
        System.out.println("请您输入您将要输入几个数:");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrInput = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("请您输入第"+(i+1)+"个数:");
            arrInput[i] = sc.nextInt();
        }
        System.out.println("============");

        for (int i = 0; i < arrInput.length; i++) {
            for (int j = 0; j < arrInput.length-1-i; j++) {
                if (arrInput[i]>arrInput[i+1]){
                    arrInput[i]=arrInput[i]+arrInput[i+1];
                    arrInput[i+1]=arrInput[i]-arrInput[i+1];
                    arrInput[i]=arrInput[i]-arrInput[i+1];
                }
            }
        }

        System.out.println(Arrays.toString(arrInput));
    }
}
