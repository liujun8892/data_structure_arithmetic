package com.jack.tree;

import java.util.HashMap;

/**
 * 实现hashMap中数组加链表的数据结构
 * @param <K>
 * @param <V>
 */
class Entry<K, V> {
    //键
    public K key;
    //值
    public V value;
    //模拟hash冲突的时候,链表的数据结构
    public Entry<K, V> next;
    //hash冲突的个数
    public int cap;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


public class MyHashMap<K, V> {
    //MyHashMap的默认容量
    private static final int Default_size = 1 << 4;
    //模拟hashMap的数组结构
    private Entry<K, V>[] data;
    //用户自定义的hashMap容量
    private int capacity;
    //记录数组已添加了的entry个数,方便0.75f扩容
    private int size;

    //提供无参构造方法和有参构造法
    public MyHashMap() {
        this(Default_size);
    }


    public MyHashMap(int capacity) {
        //判断用户传入的容量
        if (capacity <= 0) {
            this.capacity = Default_size;
        } else {
            this.capacity = capacity;
        }
        data = new Entry[capacity];
    }

    //提供一个put方法
    public void put(K key, V value) {
        //先对传入的key进行hash
        int hashKey = hash(key);
        //新建一个entry
        Entry<K, V> newEntry = new Entry<>(key, value, null);
        Entry<K, V> entry = data[hashKey];
        //发生了hash冲突,比较链表的key
        while (entry != null) {
            if (entry.key.equals(key)) {
                //键相同,值覆盖
                entry.value = value;
                //下面的操作都不执行了
                return;
            }
            //不相等的话遍历链表,直到找到最后一个entry为null,那么entry下移,头插新的entry
            entry = entry.next;
        }
        newEntry.next = entry;
        data[hashKey] = newEntry;
        size++;
    }

    //提供一个get方法
    public V get(K key) {
        //hashMap可以允许有一个key为null,这里不模拟那种情况
        if (key != null) {
            int hash = hash(key);
            Entry<K, V> entry = data[hash];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    //引用源码的hash方法
    int hash(Object key) {
        int h = 0;
        if (key == null)
            h = 0;
        else {
            h = key.hashCode() ^ (h >>> 16); // 无符号右移16位
        }
        return h % capacity;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");
        hashMap.put("4", "d");
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("3"));
        System.out.println(hashMap.get("5"));
    }
}

