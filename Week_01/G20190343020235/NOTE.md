# 学习笔记
## 关于对数组、链表、栈、队列的一些总结与反思
- 数组、链表、栈、队列都是一维数据结构。其容量的增长只能往一个方向上增长
- 对于跳表这一数据结构，可以看做是二维数据结构，因为它可以往两个维度上扩展数据。第一个维度就是数据项，第二个维度
- 将数据结构以维度进行分类，感觉也是非常的巧妙
- 栈的应用：系统栈等
- 队列的应用：滑动窗口，消息队列等
## 学习总结
- 不要死磕
- 学习别人的长处，代码风格，解题思路，融为己用
## 代码改写
```
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a"); 
deque.addFirst("b"); 
deque.addFirst("c"); 
System.out.println(deque);
String str = deque.peekFirst(); 
System.out.println(str); 
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.removeFirst()); 
}
System.out.println(deque);
```

## Queue 源码分析
- uml继承结构图 Queue----extends>Collection----extends>Iterable
- Queue 是一个接口，包含了 add(), offer(), remove(), poll(), element(), peek()六种方法，以及 Collection, Iterable 中的所有接口
- add()方法将指定元素入队，如果空间不足会抛IllegalStateException异常
- offer()方法与 add 方法类似，向队列中添加元素，如果队列空间有限，则推荐使用 add()方法
- remove()方法，删除队列的队首元素，如果队列为空，则抛异常
- poll()方法，删除队列的队首元素，如果队列为空，则返回 null
- element()方法，返回队首元素，如果队列为空则抛异常
- peek()方法，返回队首元素，如果队列为空返回 null
## PriorityQueue 源码分析
- uml 继承图
    - ![image](https://user-images.githubusercontent.com/7427587/70772498-ad2b4d80-1daf-11ea-841b-cb4ad49d8d3d.png)
    - 内部是采用堆作为优先队列的底层数据结构
    - add 时会 siftup(), remove()时会 siftdown() 保证其优先级
    - 有个疑问，超哥讲的priority queue 的插入操作的时间复杂度是 O(1)是基于什么考虑的，如果底层数据结构是堆，那么它的插入操作的时间复杂度不应为 O(1)吧。
    - PS:对 java 不是很熟，源码分析，只能是简单的看下实现了