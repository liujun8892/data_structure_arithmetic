package com.jack.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        //实现希尔排序
        System.out.println("请您输入您将要输入几个数:");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrInput = new int[length];
        for (int i = 0; i < length; i++) {
            arrInput[i] = sc.nextInt();
        }

        int step = length/2;
        while (step >= 1) {
            for (int i = step; i < length; i++) {
                for (int j = i; j-step >=0; j -= step) {
                    if (arrInput[j] < arrInput[j - step]) {
                        arrInput[j] = arrInput[j] + arrInput[j - step];
                        arrInput[j - step] = arrInput[j] - arrInput[j - step];
                        arrInput[j] = arrInput[j] - arrInput[j - step];
                    } else {
                        break;
                    }
                }
            }
            step = step / 2;
        }

        System.out.println(Arrays.toString(arrInput));
    }
}
