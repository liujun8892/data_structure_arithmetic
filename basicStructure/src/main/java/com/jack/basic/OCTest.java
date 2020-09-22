package com.jack.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//时间复杂度和空间复杂度的demo
public class OCTest {

    void OOM() {
        //空间复杂度:O(n)
//        int[] a = new int[n];
        //Map:static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16-->O(16)
        Map<String,String> map =new HashMap<String,String>();
        //List private static final int DEFAULT_CAPACITY = 10;O(10)
        List<String> list =new ArrayList<String>();
    }

    void Time(){

        //常数时间复杂度为O(1)
        //时间复杂度为O(1)
        int a =1;
        //时间复杂度为O(1)
        int b =a+1;
        //循环次数确实为100次,因为100是常熟,所以时间复杂度还是O(1)
        for (int i = 0; i < 100; i++) {

        }

        //线性,时间复杂度为O(m)
        int m;
//        for (int i = 0; i < m; i++) {
//
//        }

        //对数性,时间复杂度为nlog(n)
 //       for (int i = 0; i < n; i++) {
 //           while (c<n){
//                c=c*2;
//        }

        //平方性,O(n^2)
//        for (int i = 0; i < n; i++) {
//            for (int i = 0; i < n; i++) {
//
//            }
//        }

//        for (int i = 0; i < =n; i++) {
//            for (int j = i; j <= n; j++) {
//
//            }
//        }

        /**
         * i=n 里层1
         * i=n-1,里层2
         * i=n-2,里层为3
         * ....
         *
         */
//        (n-1)+(n-2)+(n-3)+......+1==>n(n-1)/2//常熟不算还是为n^2

    }


}
