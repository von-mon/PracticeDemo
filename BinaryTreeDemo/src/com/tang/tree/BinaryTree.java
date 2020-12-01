package com.tang.tree;

/**
 * @ClassName: BinaryTree
 * @author: TZL
 * @date: 2020/11/30  17:00
 * @Description: 建立二叉树的小栗子
 */
public class BinaryTree {

    //根节点
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    private void buildTree(Node node, Integer data) {
        //根节点为空，设置根节点
        if (root == null) {
            root = new Node(data);
        } else {
            //根节点不为空
            if (data < node.getData()) {
                //小于当前结点的值，则判断左结点是否存在
                if (node.getLeft() == null) {
                    //左结点不存在,设置左结点
                    node.setLeft(new Node(data));
                } else {
                    //如果存在，传入左结点,进入递归
                    buildTree(node.getLeft(), data);
                }
            } else {
                //大于或等于当前结点的值，则判断右结点
                if (node.getRight() == null) {
                    //右结点为空，则设置右结点
                    node.setRight(new Node(data));
                } else {
                    //如果存在，传入右结点,进入递归
                    buildTree(node.getRight(), data);
                }
            }
        }
    }

    /**
     * 建立树
     *
     * @param data 树的数据
     */
    public static BinaryTree createTree(Integer[] data) {
        BinaryTree binaryTree = new BinaryTree();
        for (Integer treeData : data) {
            binaryTree.buildTree(binaryTree.getRoot(), treeData);
        }
        return binaryTree;
    }

    /**
     * 前序遍历
     *
     * @param node 结点
     */
    private static void preTraversal(Node node) {
        if (node == null) return;
        System.out.println(node.getData());
        preTraversal(node.getLeft());
        preTraversal(node.getRight());
    }

    /**
     * 前序遍历
     *
     * @param binaryTree 树的实例
     */
    public static void preTraversal(BinaryTree binaryTree) {
        preTraversal(binaryTree.getRoot());
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void midTraversal(Node node) {
        if (node == null) return;
        preTraversal(node.getLeft());
        System.out.println(node.getData());
        preTraversal(node.getRight());
    }

    /**
     * 中序遍历
     *
     * @param binaryTree
     */
    public static void midTraversal(BinaryTree binaryTree) {
        midTraversal(binaryTree.getRoot());
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    private static void posTraversal(Node node) {
        if (node == null) return;
        posTraversal(node.getLeft());
        posTraversal(node.getRight());
        System.out.println(node.getData());
    }

    /**
     * 后序遍历
     *
     * @param binaryTree
     */
    public static void posTraversal(BinaryTree binaryTree) {
        posTraversal(binaryTree.getRoot());
    }

    /**
     * 树的结点类
     * left:左指针
     * right:右指针
     * data:数据域
     */
    private static class Node {
        private Node left;
        private Node right;
        private Integer data;

        public Node(Integer data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{data=" + data + '}';
        }
    }
}
