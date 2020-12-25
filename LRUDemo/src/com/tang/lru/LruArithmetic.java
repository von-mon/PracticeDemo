package com.tang.lru;

import com.tang.node.Node;

import java.util.HashMap;

/**
 * @ClassName: LruArithmetic
 * @author: TZL
 * @date: 2020/12/25  10:00
 * @Description: LRU（Least Recently Used Cache）算法（最近最少使用算法）
 * 增：如果是新元素则添加到头结点
 * 删：直接删除
 * 改：改变元素的值并移动到头结点
 * 查：获取元素的值并移动到头结点
 */
public class LruArithmetic<K, V> {
    /**
     * 当前数组大小
     */
    private int mCurrentSize;
    /**
     * 总容量
     */
    private int mCapacity;
    /**
     * 总结点数
     */
    private HashMap<K, Node> mCaches;
    /**
     * 头结点
     */
    private Node mHead;
    /**
     * 尾结点
     */
    private Node mTail;

    public LruArithmetic(int size) {
        mHead = null;
        mTail = null;
        this.mCurrentSize = 0;
        this.mCapacity = size;
        this.mCaches = new HashMap<>(size);
    }

    public static void main(String[] args) {
        LruArithmetic<Integer, String> lruArithmetic = new LruArithmetic<>(10);
        lruArithmetic.put(1, "a");
        lruArithmetic.put(2, "b");
        lruArithmetic.put(3, "c");
        lruArithmetic.put(4, "d");
        lruArithmetic.put(5, "e");
        lruArithmetic.put(6, "f");
        lruArithmetic.put(7, "g");
        lruArithmetic.put(8, "h");
        lruArithmetic.put(9, "j");
        System.out.println("开始的链表：" + lruArithmetic.toString());
        lruArithmetic.get(5);
        System.out.println("获取之后的链表：" + lruArithmetic.toString());
        lruArithmetic.put(10, "love");
        System.out.println("添加之后的链表：" + lruArithmetic.toString());
        lruArithmetic.remove(1);
        System.out.println("删除之后的链表：" + lruArithmetic.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node node = mHead;
        while (node.next != null) {
            builder.append(String.format("%s->%s ", node.key, node.value));
            node = node.next;
        }
        return "LruArithmetic{" + builder.toString() + '}';
    }

    /**
     * 添加新元素
     *
     * @param key   键
     * @param value 值
     */
    public void put(K key, V value) {
        Node node = mCaches.get(key);
        //如果是新元素
        if (node == null) {
            //当前的容量要大于最大容量
            if (mCaches.size() >= mCapacity) {
                //移除最后一个元素
                mCaches.remove(mTail.key);
                removeLast();
            }
            //创建新结点
            node = new Node(key, value);
        }
        //已存在的元素，则覆盖值
        node.value = value;
        //移动到头部
        moveToHead(node);
        //添加到map
        mCaches.put(key, node);
    }

    /**
     * 获取值
     *
     * @param key 键
     * @return 值
     */
    public Object get(K key) {
        Node node = mCaches.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }


    /**
     * 移除元素
     *
     * @param key 键
     * @return 值
     */
    public Object remove(K key) {
        Node node = mCaches.get(key);
        //结点存在
        if (node != null) {
            //结点的后一个结点不为空
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            //结点的前一个结点不为空
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            //结点为尾结点
            if (node == mTail) {
                mTail = node.pre;
            }
            //结点为头结点
            if (node == mHead) {
                mHead = node.next;
            }
        }
        //删除并返回
        return mCaches.remove(key);
    }

    /**
     * 移动结点到头部
     *
     * @param node 结点
     */
    private void moveToHead(Node node) {
        //结点为头结点
        if (mHead == node) {
            return;
        }
        //结点的后一个结点不为空
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        //结点的前一个结点不为空
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        //结点为尾结点
        if (node == mTail) {
            mTail = node.pre;
        }
        //头结点或尾结点为空
        if (mHead == null || mTail == null) {
            mHead = node;
            mTail = node;
        } else {
            //移动结点到头部
            node.next = mHead;
            mHead.pre = node;
            mHead = node;
            mHead.pre = null;
        }

    }

    /**
     * 移除尾结点
     */
    private void removeLast() {
        if (mTail != null) {
            mTail = mTail.pre;
            if (mTail == null) {
                mHead = null;
            } else {
                mTail.next = null;
            }
        }
    }


}
