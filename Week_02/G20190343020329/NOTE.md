学习笔记:

HashMap:
1.底层通过散列表实现（链表数组）
2.要存放的key必须要有合适的hash方法，自定义的对象覆写hash方法时，必须同时覆写equals方法，因为hashMap内部调用了对象的hash和equals方法。
3.hash函数的选取非常重要，它决定了key放在散别表的位置，以及多个key产生冲突的概率，好的hash方法可以将key均匀分布到散列表里
4.在使用HashMap时一定要注意该map里即将放入的元素的个数，尽量大于元素个数，同时又不浪费空间；一方面是减少空间，另一方面是减少resize，resize相对耗时。

实战：
1异位词：
a.sort
b.hashMap
变种：49题
2.2SUM


方式方法：
1。clarification 题意
2。possible solution->better (time and space)
3。coding
4。test cases


树的面试题解法一般都是递归，为什么？
树的结构决定了该解题思路，树有根结点，根结点有儿子节点；而儿子节点又是一棵树，依次类推，以每个节点为起点，都是一棵独立的树，具有重复性。