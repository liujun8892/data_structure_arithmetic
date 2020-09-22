package com.jack.basic;

import java.util.Arrays;
import java.util.Random;

public class PeopleTest {
    public static void main(String[] args) {
        int[] peopleArr = new int[200];
        //模拟统计各年龄段的人口
        Random random = new Random();
        for (int i = 0; i < peopleArr.length; i++) {
           peopleArr[i] = random.nextInt(100) * 100;
        }
        //人口按年龄从小到大输出
        System.out.println(Arrays.toString(peopleArr));
        for (int i = 0; i < peopleArr.length; i++) {
            System.out.println("人口是"+i+"岁的:");
            for (int j = 0; j < peopleArr[i]; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
