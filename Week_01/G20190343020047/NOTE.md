# 学习笔记
## Java 改造deque
Deque<String> deque = new LinkedList<String>();

deque.addFirst("0");
deque.addLast("1");

System.out.println(deque);

String str = deque.peekFirst();

System.out.println(str);
System.out.println(deque);

while (deque.size() > 0 ){
    System.out.println(deque.removeFirst());
}

System.out.println(deque);

## Queue源码
在Java中，queue是Interface，有很多种实现方法比如ArrayQueue、LinkedList、ConcurrentLinkedQueue等等
主要包括的方法插入：add(e)、offer(e);查询element()、peek();删除remove()、poll()
每种方法的前者是会在报错时抛出异常比如add(e)在e为null时会抛出NullPointerException ，
后者是会返回boolean

##PriorityQueue
优先队列继承了AbstractQueue，也实现了序列化
PriorityQueue有多个构造函数
