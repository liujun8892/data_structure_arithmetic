package com.jack.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeastSort implements Comparable<FeastSort>{

    private int startTime;

    private int endTime;

    private int feastNum;

    public FeastSort(int startTime, int endTime, int feastNum) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.feastNum = feastNum;
    }

    //结束时间早的饭局排在前面
    @Override
    public int compareTo(FeastSort o) {
        return this.endTime>o.endTime?1:-1;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getfeastNum() {
        return feastNum;
    }

    public void setfeastNum(int feastNum) {
        this.feastNum = feastNum;
    }

    @Override
    public String toString() {
        return "FeastSort{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", feastNum=" + feastNum +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入总饭局数");
        int totalFeastCount = sc.nextInt();
        List<FeastSort> feastSortList = new ArrayList<>();
        for (int i = 0; i < totalFeastCount; i++) {
            System.out.println("请输入第"+(i+1)+"场饭局开始和结束时间");
            FeastSort feastSort = new FeastSort(sc.nextInt(),sc.nextInt(),i+1);
            feastSortList.add(feastSort);
        }
        //使用FeastSort中重写的compareTo方法排序
        feastSortList.sort(null);

        //过滤饭局,本场饭局的开始时间要小于上一场饭局的结束时间,结束时间不能超过24:00
        int currentTime = 0;
        for (FeastSort feastSort : feastSortList) {
            if (feastSort.getStartTime()>currentTime && feastSort.getEndTime()<24){
                System.out.println(feastSort);
                currentTime = feastSort.getEndTime();
            }
        }
    }
}
