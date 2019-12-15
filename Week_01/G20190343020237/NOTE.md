第一周学习总结
==============

总结
----

一维数据结构:

-   数组、链表
    -   数组，是一块连续的内存空间，可以根据下标快速获取元素值,
        而插入、删除元素效率低O(n), 因为会造成内存数据的群移
    -   链表只可以从head,
        tail指针遍历元素查找元素，但插入、删除效率高，内部非连续存储空间，可以通过next,
        prev指针的操作快速实现插入、删除
-   stack, queue, deque, priority queue

twoSum, threeSum, FourSum, nSum

-   复杂度可以做到比暴力枚举少一层循环, 2sum\~O(n), 3sum\~O(n^2^)
-   2sum可以哈希表实现
-   3sum可以先排序，用头尾指针遍历实现，通过操纵指针的跳转，快速实现去重，而不是每次都去set()里查找

双端循环链表:

-   \[head, tail),
    左闭右开，可以让代码简洁很多，通过浪费一个元素的存储空间，来区分isEmpty()和isFull()
    -   isEmpty(): head==tail
    -   isFull(): head==(tail+1)%k

双指针的套路:

-   针对排序元素，一头一尾向中间遍历
-   快慢指针，判断链表是否有环

代码改写
--------

``` {.java}
// // old API
// Deque<string> deque = new LinkedList<String>();
// deque.push("a");
// deque.push("b");
// deque.push("c");
// System.out.println(deque);

// String str=deque.peek();
// System.out.println(str);
// System.out.println(deque);

// while (deque.size()>0) {
// System.out.println(deque.pop());
// }
// System.out.println(deque);


// new API
Deque<string> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str=deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size()>0) {
System.out.println(deque.removeFirst());
}
System.out.println(deque);
```

Queue, Priority Queue 源码分析
------------------------------

来源: openjdk-13-source

### queue

java中Queue是一个接口，提供以下两类API, 对应插入、删除、获取三种操作。

            Throws exception   Returns special value
  --------- ------------------ -----------------------
  Insert    add(e)             offer(e)
  Remove    remove()           poll()
  Examine   element()          peek()

这里主要分析ArrayDeque和LinkedList两个类的实现。

1.  ArrayDeque:

    底层数据用数组实现，用head,
    tail两个指针维护队列，实际上是一个双端循环队列(stack + queue):

    -   head表示deque的头部元素, 对应remove()返回的元素
    -   tail表示未来\*下一个\*元素入队的位置

    其中:

    -   head==tail, 表示isEmpty()
    -   没有isFull()函数，其中每次addLast, addFirst,
        add内部，都会检查队列是否满，如果满的话, grow(1), 保证head!=tail

      函数      内部实现                        Time
      --------- ------------------------------- ------
      add       addaLast()                      O(1)
      remove    removeFirst() -\> pollFirst()   O(1)
      element   getFirst()                      O(1)

2.  LinkedList

    底层数据用链表实现, 用first, last两个指针表示链表的头尾指针

      函数      内部实现                          Time
      --------- --------------------------------- ------
      add       linkLast()                        O(1)
      remove    removeFirst() -\> unlinkFirst()   O(1)
      element   getFirst() -\>                    O(1)

### priority queue

类PriorityQueue实现了Queue接口, 底层数据用最小heap(内部实际是一个数组,
父结点值比子节点值小)实现

  函数      内部实现                          复杂度
  --------- --------------------------------- -----------------
  add       offer() -\> siftUp()              O(logn), 维护堆
  remove    poll() -\> siftDownComparable()   O(logn), 维护堆
  element   queue\[0\]                        O(1)
