  数据结构总结:
  - HashMap: HashMap中冲突解决方式是开放寻址法和链表法，因为冲突的存在，HashMap中背后的数组或链表中的元素需要同时存储在<k, v>, 而不是v
  - 二叉树: 遍历中。总是先左后右, 根的位置决定了前中后序遍历：
    - 前序遍历(根左右)
    - 中序遍历(左根右)
    - 后序遍历(左右根)

  - 树的定义本身就是递归定义，树的问题通过递归解决，代码会非常简洁，递归和循环类似, 背后是系统维护的函数调用栈，所以也可以自己手动维护一个栈，通过循环实现相同功能。

  - 递归的写法:
    - 终止条件
    - update state
    - 递归
    - reset state

  - 递归中全局变量的维护，可以通过全局变量或函数参数来维护。待进一步探索

** 问题

   递归、BackTrack、动态规划的关系，待进一步整理

** HashMap


  来源: aptitude install openjdk-13-source, java.base/java/util/HashMap.java

  基于数组、单链表、红黑树实现的哈希表, 非线程安全。

  内部用Node<K, V>数组table实现:
  - 该数组大小为容量capacity, 如果插入元素后，元素数/容量>装载因子(Load Factor), 数组会动态扩容，大小翻倍
  - 该数组中每个元素Node对应一个*单链表或BST* (二叉搜索树, 红黑树)，用于解决键冲突。
    - 如果某个key对应的冲突元素数目少(<TREEIFY_THRESHOLD)，是一个单链表, 查找时间复杂度为O(N), N为单链表长度；
    - 否则，是一个BST(按hash值排序好的，平衡的二叉搜索树)，查找时间复杂度为O(logN), N为冲突元素数目。


  #+begin_src dot :file hashmap.svg
  digraph hash_map {
  label="HashMap = 数组 + 单链表 + 红黑树"
  node [shape=label]
  rankdir=TB;

  table [shape=record, label="<a>ka:va |　　 |　　 |　　|<b>kb:vb|　　|kc:vc", size=150]
  table:a -> a1 -> a2
  a1[label="kd:vd"]
  a2[label="ke:ve"]
  b2 [fillcolor="red", style=filled, label="kg:vg"]
  b3 [fillcolor="red", style=filled, label="kh:vh"]
  b4 [fillcolor="black", style=filled, fontcolor="white", label="ki:vi"]
  b5 [fillcolor="balck", style=filled, fontcolor="white", label="kj:vj"]
  b6 [fillcolor="black", style=filled, fontcolor="white", label="kk:vk"]
  b7 [fillcolor="balck", style=filled, fontcolor="white", label="kl:vl"]


  table:b -> {b2, b3}
  b2 -> {b4, b5  }
  b3 -> {b6, b7  }
  }
  #+end_src

  #+RESULTS:


