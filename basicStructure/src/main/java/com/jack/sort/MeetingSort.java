package com.jack.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeetingSort implements Comparable<MeetingSort>{

    private int startTime;

    private int endTime;

    private int meetingNum;

    public MeetingSort(int startTime, int endTime, int meetingNum) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingNum = meetingNum;
    }

    //结束时间早的会议排在前面
    @Override
    public int compareTo(MeetingSort o) {
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

    public int getMeetingNum() {
        return meetingNum;
    }

    public void setMeetingNum(int meetingNum) {
        this.meetingNum = meetingNum;
    }

    @Override
    public String toString() {
        return "MeetingSort{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", meetingNum=" + meetingNum +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入总会议数");
        int totalMeetingCount = sc.nextInt();
        List<MeetingSort> meetingSortList = new ArrayList<>();
        for (int i = 0; i < totalMeetingCount; i++) {
            System.out.println("请输入第"+(i+1)+"场会议开始和结束时间");
            MeetingSort meetingSort = new MeetingSort(sc.nextInt(),sc.nextInt(),i+1);
            meetingSortList.add(meetingSort);
        }
        //使用MeetingSort中重写的compareTo方法排序
        meetingSortList.sort(null);

        //过滤会议,本场会议的开始时间要小于上一场会议的结束时间,结束时间不能超过24:00
        int currentTime = 0;
        for (MeetingSort meetingSort : meetingSortList) {
            if (meetingSort.getStartTime()>currentTime && meetingSort.getEndTime()<24){
                System.out.println(meetingSort);
                currentTime = meetingSort.getEndTime();
            }
        }
    }
}
