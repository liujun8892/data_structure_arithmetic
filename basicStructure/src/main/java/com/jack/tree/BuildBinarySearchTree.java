package com.jack.tree;

/**
 * @author liujun
 * 手撕一颗搜索二叉树（中序遍历的时候，能从小到大排列）
 */
public class BuildBinarySearchTree {
    private int data;
    private BuildBinarySearchTree left;
    private BuildBinarySearchTree right;

    public BuildBinarySearchTree(int data) {
        this.data = data;
    }

    public BuildBinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BuildBinarySearchTree left) {
        this.left = left;
    }

    public BuildBinarySearchTree getRight() {
        return right;
    }

    public void setRight(BuildBinarySearchTree right) {
        this.right = right;
    }

    //提供构建一颗搜索二叉树(中序遍历的时候必须是有序的)方法
    public static void insert(BuildBinarySearchTree root,int data){
        //新插入的节点比根节点大,则放入根结点的右边
        if (root.data<data){
            if (root.getRight()==null){
                BuildBinarySearchTree buildBinarySearchTree = new BuildBinarySearchTree(data);
                root.setRight(buildBinarySearchTree);
            }else {
                insert(root.getRight(),data);
            }
        }else if (root.data>data){
            //新插入的节点比根节点大,则放入根结点的左边
            if (root.getLeft()==null){
                BuildBinarySearchTree buildBinarySearchTree = new BuildBinarySearchTree(data);
                root.setLeft(buildBinarySearchTree);
            }else {
                insert(root.getLeft(),data);
            }
        }
    }


    //提供一个中序遍历的方法
    static void in(BuildBinarySearchTree root){
        if (root.getLeft()!=null)
        in(root.getLeft());
        System.out.println(root.data);
        if (root.getRight()!=null)
        in(root.getRight());
    }
    static int findCount = 0;
    //提供一个查找的方法
    static void findData(BuildBinarySearchTree root,int searchData){
        try {
            if (root.data<searchData){
                findCount++;
                findData(root.getRight(),searchData);
            }else if(root.data>searchData){
                findCount++;
                findData(root.getLeft(),searchData);
            }else {
                System.out.println("一共查找了:"+findCount+"次"+"找到的结点是:"+ root+"  找的数是:"+ root.data);
            }
        }catch (NullPointerException e){
            System.out.println("该二叉搜索树中没有查找到...");
        }

    }


    public static void main(String[] args) {
        int[] data = {5,4,7,3,1,9,6,2,8};
        BuildBinarySearchTree buildBinarySearchTree = new BuildBinarySearchTree(data[0]);

        for (int i = 1; i < data.length; i++) {
            insert(buildBinarySearchTree,data[i]);
        }

        //遍历输出，看搜索二叉树是否排列好
        in(buildBinarySearchTree);

        //从构建好的搜索二叉树查询某个数是否存在二叉树之中
        findData(buildBinarySearchTree,3);

    }
}
