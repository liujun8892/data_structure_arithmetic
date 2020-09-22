package com.jack.sort;

public class DynamicProgrammingAlgorithm {
    public static void main(String[] args) {
        //商品的重量和价格
        int[] value = {70,60,120};
        int[] weight = {30,20,40};

        //商品的总数量和背包可以承受的最大重量
        int goodsCount = weight.length;
        int bagWeight = 50;
        //商品总数和背包承受重量的矩阵
        int[][] gb = new int[goodsCount+1][bagWeight+1];

        //循环每件商品
        for (int i = 1; i <= goodsCount; i++) {
            //动态规划书包承重,单位为1
            for (int j = 1; j <= bagWeight; j++) {
                //判断当前商品的重量小于动态规划的背包承重
                if (weight[i-1]<=j){
                    //gb矩阵,从当前值和上一个值中取最大
                    gb[i][j]=Math.max(value[i-1]+gb[i-1][j-weight[i-1]]//新装物品的价值+当前矩阵剩余空间和上一个物品定位矩阵的值
                            ,gb[i-1][j]//装不下就取上一个物品
                    );
                }else {
                    //证明背包放不下该商品的重量,取矩阵上一行的值
                    gb[i][j]=gb[i-1][j];
                }
            }
        }


        System.out.println("购物车在受重范围内能带走的最大商品价值为:"+gb[goodsCount][bagWeight]+"元");
    }

}
