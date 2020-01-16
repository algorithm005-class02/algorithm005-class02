学习笔记

一、用add first或add last这套新的API改写Deque的代码
void newDequeLast() {
    Deque<String> deque = new LinkedList<String>();
    /* push()=addFirst()
    deque.push("a");
    deque.push("b");
    deque.push("c");
    */
    deque.addFirst("b");
    deque.addFirst("c");
    deque.addLast("a");
    System.out.println(deque);
    String str = deque.element();
    System.out.println(str);
    System.out.println(deque);
    while (deque.size() > 0) {
        System.out.println(deque.remove());
    }
    System.out.println(deque);
}


二、分析Queue和Priority Queue的源码
1.LinkedList实现了Deque，Deque继承了Queue，PriorityQueue实现了Queue。链表和队列实质上是操作队列的插入和删除
2.Stack继承了Vector，栈实际上数组的操作，Vector跟ArrayList都是数组，不同的是Vector是线程安全但访问速度慢，数组空间不足Vector扩容2倍而ArrayList扩容1.5倍
3.ArrayList、Vector、LinkList实现了List，List是一个有序的对象集合，允许存储重复的值，允许位置访问和插入元素
4.List、Queue、Set继承了Collection，集合是一组表示为单个单元的单个对象


三、学习总结
leetcode刷题套路：
1.暴力刷题法（loop）
2.归纳法：
    1.斐波那契公式
3.其他方法：
    1.数组 - 坐标交换、哈希表存储、左右夹逼
    2.链表 - 双指针（快慢指针）