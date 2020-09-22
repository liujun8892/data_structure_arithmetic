package com.jack.tree;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        playNumber(0,100,number);
//        int left = 0;
//        int right = 100;
//        while (true) {
//            int i = (left + right) / 2;
//            System.out.println(i);
//            if (i == number) {
//                System.out.println("你猜对了");
//                break;
//            }
//            if (i > number) {
//                System.out.println("你输入的数字大了");
//                right = i;
//            }
//            if (i < number) {
//                System.out.println("你输入的数字小了");
//                left = i;
//            }
//        }
    }


    public static void playNumber(int left, int right, int number) {
        int i = (left + right) / 2;
        System.out.println(i);
        if (i == number)
            System.out.println("你猜对了");
        if (i>number){
            System.out.println("你输入的数字大了");
            playNumber(left,i,number);
        }
        if (i<number){
            System.out.println("你输入的数字小了");
            playNumber(i,right,number);
        }
    }


}
