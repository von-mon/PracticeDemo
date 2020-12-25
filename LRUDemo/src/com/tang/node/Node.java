package com.tang.node;

/**
 * @ClassName: Node
 * @author: TZL
 * @date: 2020/12/25  9:45
 * @Description: 链表结点
 */
public class Node {
    /**
     * 键
     */
   public Object key;
    /**
     * 值
     */
    public Object value;
    /**
     * 前一个结点
     */
    public Node pre;
    /**
     * 后一个结点
     */
    public Node next;

    public Node(Object key, Object value){
        this.key = key;
        this.value = value;
    }
}
