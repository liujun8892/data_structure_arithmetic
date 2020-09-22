package com.jack.tree;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author liujun
 * 实现一颗哈夫曼树，并提供加解密方法
 */
class MyNode implements Comparable<MyNode>{
    private String data;
    private int weight;
    private MyNode parentNode;
    private MyNode leftNode;
    private MyNode rightNode;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public MyNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(MyNode parentNode) {
        this.parentNode = parentNode;
    }

    public MyNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyNode leftNode) {
        this.leftNode = leftNode;
    }

    public MyNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int compareTo(MyNode o) {
        return this.weight>o.weight?1:-1;
    }
}


public class HumanTree {
    private MyNode root;
    private List<MyNode> leafNodeList;
    private Map<Character,Integer> weightMap;

    public HumanTree(Map<Character, Integer> weightMap) {
        this.leafNodeList = new ArrayList<>();
        this.weightMap = weightMap;
    }

    //构建树
    public void createTree(){
        //使用优先队列从小到大排列
        PriorityBlockingQueue<MyNode> myNodeQueue = new PriorityBlockingQueue<>();
        Set<Character> characters = weightMap.keySet();
        for (Character character : characters) {
            MyNode myNode = new MyNode();
            myNode.setData(character+"");
            myNode.setWeight(weightMap.get(character));
            myNodeQueue.add(myNode);
            leafNodeList.add(myNode);
        }
        //合
        for (int i = 0; i < leafNodeList.size()-1; i++) {
            //取出最小的两个做叶子节点
            MyNode leftNode = myNodeQueue.poll();
            MyNode rightNode = myNodeQueue.poll();
            MyNode parentNode = new MyNode();
            //断言
            assert leftNode != null;
            assert rightNode != null;
            parentNode.setData(leftNode.getData()+rightNode.getData());
            parentNode.setLeftNode(leftNode);
            parentNode.setRightNode(rightNode);
            leftNode.setParentNode(parentNode);
            rightNode.setParentNode(parentNode);
            myNodeQueue.add(parentNode);
        }
        //队列的最后一个作为整颗哈夫曼数的根节点
        root=myNodeQueue.poll();
        System.out.println("哈夫曼树构建完成");

    }

    //编码
    public Map<String,String> encode(){
        Map<String,String> encodeMap = new HashMap<>();
        for (MyNode currentNode : leafNodeList) {
             MyNode temp  =  currentNode;
            String code = "";
            while (currentNode.getParentNode() != null) {
                if (currentNode.getParentNode().getLeftNode() == currentNode) {
                    code = 0 + code;
                    currentNode = currentNode.getParentNode();
                } else {
                    code = 1 + code;
                    currentNode = currentNode.getParentNode();
                }
            }
            encodeMap.put(temp.getData(), code);
        }
        return encodeMap;
    }

    //解码
    Map<String,String> decodeMap =new LinkedHashMap<>();
    public Map<String,String> decode(List<String> encodeList){
        for (String encode : encodeList) {
            MyNode currentNode = new MyNode();
            MyNode localRoot = root;
            for (int i = 0; i < encode.length(); i++) {
                char c = encode.charAt(i);
                if (c == '0'&& localRoot.getLeftNode()!=null){
                       currentNode = localRoot.getLeftNode();
                       localRoot = localRoot.getLeftNode();
                }else if (c=='1' && localRoot.getRightNode()!=null){
                    currentNode = localRoot.getRightNode();
                    localRoot = localRoot.getRightNode();
                }else {
                    //如果在最后一个 字节未找到该节点证明在哈夫曼树中没有对应的解密报文
                    System.out.println("未找到该节点的解密报文"+encode);
                }
            }
            //找到了就把密文和解密报文存入map
            decodeMap.put(encode,currentNode.getData());
        }
        return decodeMap;
    }

    public static void main(String[] args) {
        //定义报文和报文的权重
        Map<Character,Integer> weightMap = new HashMap<>();
        weightMap.put('A',7);
        weightMap.put('B',5);
        weightMap.put('C',2);
        weightMap.put('D',4);
        weightMap.put('E',8);
        HumanTree humanTree = new HumanTree(weightMap);
        //构建哈夫曼树
        humanTree.createTree();
        //
        Map<String, String> encode = humanTree.encode();
        List<String> encodeList = new ArrayList<>();
        //遍历加密
        System.out.println("编码");
        for (String s : encode.keySet()) {
            System.out.println(s+"-->"+encode.get(s));
            encodeList.add(encode.get(s));
        }
        //遍历解密

        System.out.println("-----------");
        System.out.println("解码");
        Map<String, String> decodeMap = humanTree.decode(encodeList);
        for (String s : decodeMap.keySet()) {
            System.out.println(s+"---->"+decodeMap.get(s));
        }
    }


}
