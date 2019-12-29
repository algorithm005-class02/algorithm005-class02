学习笔记
// Deque
// addFirst
Class MyDeque implements Deque {
    // 采用双向链表结构
    private class Node {
        int data;
        Node next;
        Node pre;
    }

    private Node head;
    private Node end;
    // 如果length=-1，则无容量限制；
    private int length;
    // 当前数据个数；
    private int size;
    
    public void addFirst(E object) {
        if (null == object) {
            throw new NullPointerException();
        }
        if (length != -1 && size == length) {
            throw new IllegalStateException();
        }
        // 采用双向链表添加
    }
    
    public void addLast(E object) {
        if (null == object) {
            throw new NullPointerException();
        }
        if (length != -1 && size == length) {
            throw new IllegalStateException();
        }
        // 采用双向链表添加
    }
}


// PriorityQueue源码分析
1.采用对象数组Object[]来充当队列
2.使用比较器（或元素自带顺序）来排队
3.依次出队保证按照元素的顺序性（优先级）进行
4.插入一个元素时，必须按照优先级来，势必需要额外的时间和空间来维护该队列
5.删除一个元素，也需要O(n)的时间，在O(n)时间内找到该元素，删除时需要对对象数组做移动操作

学习总结：
1.非常重要的认知：以前学的算法知识真的只是基本概念，算法就是要尽可能使用高效的方法和数据结构来解决问题。
2.算法能力需要时间磨练，如同题海战术一般，需要不断去打磨，去积累经验。
3.算法犹如数据，有很多的思想在里面，并且需要知晓用计算机来完成，那么可用的方式和策略无非就是分支/循环/递归这些基本结构，找最近重复子问题，找相关性等等。
4.非常认同老师的【五毒神掌】方法，后续会坚持使用该方法，多思考，多回顾，多总结。
5.特别的，这周了解到的比较重要的思想有两个，分别是：夹逼法则和以空间换时间。

