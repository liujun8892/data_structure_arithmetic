package com.jack.tree;


class Node {
    private char data;
    private Node leftNode;
    private Node rightNode;

    public Node(char data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}

public class RootBeforeMidBehindSort {

    public static void main(String[] args) {
        Node D = new Node('D',null,null);
        Node H = new Node('H',null,null);
        Node I = new Node('I',null,null);
        Node C = new Node('C',D,null);
        Node G = new Node('G',H,I);
        Node B = new Node('B',null,C);
        Node F = new Node('F',G,null);
        Node E = new Node('E',null,F);
        Node A = new Node('A',B,E);
       // before(A);
        //mid(A);
        after(A);
    }

    public static void print(Node node){
        System.out.println(node.getData());
    }

    public static void before(Node root){
        print(root);
        if (root.getLeftNode()!=null){
            before(root.getLeftNode());
        }
        if (root.getRightNode()!=null){
            before(root.getRightNode());
        }
    }

    public static void mid(Node root){
        if (root.getLeftNode()!=null){
            mid(root.getLeftNode());
        }
        print(root);
        if (root.getRightNode()!=null){
            mid(root.getRightNode());
        }
    }

    public static void after(Node root){
        if (root.getLeftNode()!=null){
            after(root.getLeftNode());
        }
        if (root.getRightNode()!=null){
            after(root.getRightNode());
        }
        print(root);
    }


}
