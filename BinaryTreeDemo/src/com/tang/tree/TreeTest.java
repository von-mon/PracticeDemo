package com.tang.tree;

/**
 * @ClassName: TreeTest
 * @author: TZL
 * @date: 2020/11/30  17:30
 * @Description:
 */
public class TreeTest {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.createTree(new Integer[]{7,4,9,7,5,3,89,12});
        BinaryTree.preTraversal(tree);
        System.out.println("////////////////////////////////////");
        BinaryTree.midTraversal(tree);
        System.out.println("/////////////////////////////////////");
        BinaryTree.posTraversal(tree);
    }
}
