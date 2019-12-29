# 第一周学习总结

本周的学习总结有以下几点内容：
## 学习内容

主要学习了以下几种数据结构：

* Array
* Linked list
* Skip List
* Stack
* Queue
* Deque - Double-End Queue

平时工作中经常会使用到Array,其他几种数据结构很少涉及到。可能因为我是写业务层的程序员的原因吧。通过此次学习了解到了这些数据结构中涉及到算法的复杂度以及各自的应用场景。最重要的是知道了之前经常听说过得“升维”、“以空间换时间”是在说什么。

## 算法实战

课件中给了一些Leetcode的算法题，我在本地环境搭建好了运行环境后做了第1题和第26题为本周作业，其他的会抽时间进行练习。这周的学习实际上是热身的过程，自己尝试着使用老师的解题思路：

* 5-10分钟思考
* 如果有思路，就动手写，否则马上看题解
* 默写背诵
* 自己闭卷去写

通过这样的方式去做题的话，会摆脱了以前的那种“我就不相信自己做不出来”的窘境，大大提升了学习效率。
## 源码分析

### Queue

它是从Java JDK1.5提供的接口，是Java “容器家族的成员”；接口提供了以下功能：

* add 
	给队列添加元素，在容量已满的情况下，会抛出IllegalStateException
* offer
	也是给队列添加元素，我看的是JDK1.8,LinkedList实现中，offer直接调用的add。与add唯一的区别是添加失败不会抛异常，只会返回false。
* remove

	移除元素，提供了remove(index) 与remove(object) 两种方式，测试发现，如果index越界，会被checkElementIndex校验，抛出IndexOutOfBoundsException。

* poll
	
	移除队列中的头元素。如果队列为空，返回null。
 ```
  Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.poll();
        for(String q : queue){
            System.out.println(q);
        }
 ```
 调用 queue.poll();后，打印结果为 b c d e,去看LinkedList中的实现会发现，里面实际上调用的是unlinkFirst方法，它的功能就是去掉队列中的头元素，将头指针后移。

* element

  功能是getFirst(获取队列中的第一个元素)，当取不到时会抛出NoSuchElementException

* peek
  功能也是返回first节点元素，取不到时返回null，不会抛异常。

## Priority Queue  

平时没有使用的经验，只能泛泛而谈。PriorityQueue 继承AbstractQueue抽象类，AbstractQueue又实现了Queue接口。它是一个基于优先级的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)。

* PriorityQueue 是如何实现队列的优先级的？

	* 设定队列的默认长度
	```
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	```
	* 队列容器
	```
	transient Object[] queue; // non-private to simplify nested class access
	```
	* 队列比较器 默认情况下使用的都是 自然排序比较器,优先级可以根据需求按以下两种方式进行定制：
	  * 添加的元素自身实现了Comparable接口，确保了元素是可排序的对象
	  * 如果添加元素没有实现Comparable接口，可以在创建PriorityQueue队列时直接指定比较器。 
	```
    private final Comparator<? super E> comparator;
	```
	找了一个自定义比较器的例子，使用优先队列给学生按成绩排名的例子（https://www.jianshu.com/p/f1fd9b82cb72）

	```
	 PriorityQueue<Student> q = new PriorityQueue<Student>(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                //按照分数低到高，分数相等按名字
                if(o1.getScore() == o2.getScore()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getScore() - o2.getScore();
            }
        });
        //入列
        q.offer(new Student("dafei", 20));
        q.offer(new Student("will", 17));
        q.offer(new Student("setf", 30));
        q.offer(new Student("bunny", 20));

        //出列
        System.out.println(q.poll().getName());  //Student{name='will', score=17}
        System.out.println(q.poll().getName());  //Student{name='bunny', score=20}
        System.out.println(q.poll().getName());  //Student{name='dafei', score=20}
        System.out.println(q.poll().getName());  //Student{name='setf', score=30}
	```
	最后的输出结果是：will bunny dafei setf

## Deque 示例代码改造

```
      Deque<String> deque = new LinkedList<String>();
//        deque.push("a");
        deque.addLast("a");
        deque.push("b");
//        deque.push("c");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
```

## 总结：
  对于程序员而言，写总结比写代码要难太多了。60天刻意练习，练的不仅仅是算法的提升，还有其他方面的能力。第一周，仅仅只是个warmming up。 

  课程中讲到的复杂度，算法题，我都做了笔记，没往总结中放。我想，大部分人都已经写了，我需要做的是按照笔记练习就够了。总结是一次与自己对话的过程，需要认真对待。