学习笔记:

数组: 计算机内部开辟一段连续的地址;访问的时间复杂度为O(1),插入和删除操作的时间复杂度为O(n)(不包含结尾元素);
链表: 每个元素都定义为class,两个成员变量(value,next),添加,删除操作的时间复杂度为O(1) 只需要一定指针即可,查询为0(n)
跳表: 在链表的基础上增加多级索引后形成,索引的高度为logn,查询任意数据的时间复杂度为O(logn),增加和删除元素时需要更新索引,时间复杂度为O(logn)

栈: 先入后出 添加,删除都为O(1);查询为O(n);因为是无序的 需要遍历所有元素节点
队列: 先入先出 添加,删除都为O(1);查询为O(n);因为是无序的 需要遍历所有元素节点
双端队列 deque: 栈和队列的结合体 可以最前面和最后面进行添加以及pop,;插入和删除都是O(1) 查询为O(n)

Deque使用addFist和addLast
		Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        deque.addLast("c");
        deque.addLast("c");
        deque.addLast("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);