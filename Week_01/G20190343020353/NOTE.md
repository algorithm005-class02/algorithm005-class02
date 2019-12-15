# 第一周学习笔记

## 数据结构与算法初识
之前也曾尝试过学习算法，但总是半途而废。每次打开《算法导论》，看着密集的数学公式，很快就昏错欲睡。
这次通过学习覃超老师的课程，发现原来是自己的方法不对。
算法与数据结构，确实与平时在工作写的代码不太一样，但其实也没有那难，主要还是理解和运用，
理解，就是多看别人的代码和解法，运用，先试着用别人的解题思路去解题，即使不能完全理解，先照着抄下来也行，
千万不能自己苦苦思索，有时候多敲几遍，其意自现。这时候，我发现覃超老师的五毒神掌还是很管用的，哈哈！


## 微操技巧
在练习的过程中，我发现自己写了这么多年的代码，但对于一些"微操"还是不太熟练，比如很简单的双层循环、三层循环、
左右夹逼等等，这些其实也没有什么好办法，就是练。所有的职业选手，都是从专项练习走向强大的。这是我之前特别忽略的一点。
总以为只要会了，就不用练了。

```java
// 先定义一个数组
int[] a = {1, 2, 3, 4, 5};
```

```java
// 两层循环 ，复杂度是O(n^2)
for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
    for (int j = i; j < a.length; j++) {
        System.out.print(a[j] + " ");
    }
    System.out.println("");
}
System.out.println("------------------");
```

```java
// 两层错位循环,枚举出所有的两两组合 ，复杂度是O(n^2)
for (int i = 0; i < a.length - 1; i++) {
//            System.out.print(a[i] + " ");
    for (int j = i + 1; j < a.length; j++) {
        System.out.print(a[i] + "+" + a[j] + "\t");
    }
    System.out.println("");
}
System.out.println("------------------");
```

```java
// 三层错位循环,枚举出所有的三数组合，复杂度是O(n^3)
for (int i = 0; i < a.length - 2; i++) {
    for (int j = i + 1; j < a.length - 1; j++) {
        for (int k = j + 1; k < a.length; k ++) {
            System.out.print(a[i] + "+" + a[j] + "+" + a[k] + "\t");
        }
    }
    System.out.println("");
}
System.out.println("------------------");
```

```java
//首尾循环，向中间夹逼, ，复杂度是O(n)
for ( int i = 0, j = a.length - 1; i < j; i++, j--) {
    System.out.println(a[i] + " " + a[j]);
}
```

## 数组（Array)
访问速度很快O(1)，但修改很慢，每一次添加或者删除都会带来群移操作，复杂度是O(N)，所以如果业务中需要频繁修改的数据，不适合用数组。
Java里面的ArrayList就是一个Array，通过分析ArrayList的代码，可以发现，每次调用

### 

## 链表 (LinkedList)
链接的修改操作比较快O(1), 而访问速度比较慢O(N)。
链表又分为以下几种类型：
1. 单向链表：只有next指针
1. 双向链表: 有next和previous指针
1. 环形链表: 

Java里面的LinkedList采用的就是双向链表。
链表的题看似比较简单，但写起来比较烧脑，而且很容易遗忘，这个需要多加练习。
有一道反转链表的题目很具有代表性，这个题我觉得官方讲解就很好。 https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
一、迭代法 时间O(N)，空间O(1)
1. 创建临时变量指向下一个节点
1. 下一个节点指向前一个节点（如果当前节点是第一个节点，则为空，也就是变成了最后一个节点了）
1. 前一个节点 = 当前节点
1. 当前节点= 下一个节点
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
```
核心逻辑就是while循环里的那四行代码，直接背下来就行了。

二、递归法 时间O(N)，空间O(N)
```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}
```

链表各项操作的时间复杂度
1. prepend O(1)
1. append O(1)
1. lookup O(n)
1. insert O(1)
1. delete O(1)

### 跳表
跳表是一种优化过的链表，具有相对较快的访问速度。主要思想还是空间换时间（升维）。
平时主要用到的地方主要在redis里面，
需要思考一下的是Redis里面的Sorted set为什么使用跳表而不是红黑树，这个由于目前还不太了解红黑树，所以网上的答案看的也是云里雾里，有待以后继续学习。
通过跳表的实现，也可以总结出几种提升链接访问速度的方法：
1. 升维，也就是空间换时间
1. 增加索引
1. 添加头指针、中指针、尾指针


