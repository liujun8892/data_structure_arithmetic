package com.jack.basic;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

class  Task implements Comparable<Task>{
    private int value =1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Task o) {
        return this.value>o.value?-1:1;
    }

    @Override
    public String toString() {
        return "Task{" +
                "value=" + value +
                '}';
    }
}

//数据结构的demo
public class StructureTest {

    //array
    void arrayTest(){
        //底层数组,有下标,适合做查询多的容器
        List<Integer>  arrayList = new ArrayList<Integer>();
        //有指针,适合做增删多的容器
        List<Integer> linkedList = new LinkedList<Integer>();
        //线程安全,但效率慢
        Vector<Integer> vector =new Vector<Integer>();
    }


    //set
    void setTest(){
        //乱序去重,与插入的顺序不同
        Set<Integer> hashSet = new HashSet<Integer>();
        //排序去重,与插入的顺序不同
        Set<Integer> treeSet = new TreeSet<Integer>();
        //去重,与插入的顺序相同
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();

    }

    //Queue
    public static void main(String[] args) {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Task task1 = new Task();
        task1.setValue(1);
        Task task2 = new Task();
        task2.setValue(2);
        priorityBlockingQueue.add(task1);
        priorityBlockingQueue.add(task1);
        priorityBlockingQueue.add(task2);
        priorityBlockingQueue.add(task1);
        Iterator<Task> iterator = priorityBlockingQueue.iterator();
      while (iterator.hasNext()) {
          System.out.println(iterator.next());
      }
    }


}
