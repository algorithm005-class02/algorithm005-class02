学习笔记

# 80. Remove Duplicates from Sorted Array

Last visited: Dec 01, 2019
Star: ⭐️
Tag: 2P
Type: Easy, Medium
🚴‍♀️Count: 2

## 复习思想：找最小重复单元 - 万变不离其宗

- if else
- loop
- recursion

## 本题重复单元：

- 微操：
    - count数清楚！
    - 同向双指针带count的遍历覆盖👍
    - 同向双指针在条件判断下的遍历覆盖👍👍

## 26. Remove Duplicates from Sorted Array

    var removeDuplicates = function(nums) {
        if (!nums || !nums.length) return 0;
        
        let j = 1;
        for (let i = 1; i < nums.length; i++) {
            if (nums[i] !== nums[j]) nums[++j] = nums[i];
        }
        
        return j + 1;
    };

## 80. Remove Duplicates from Sorted Array II

### 1. 我的实现

尝试用high-level programming封装具体实现

但是还是用的bottom-up的思路

    var removeDuplicates = function(nums) {
        if (!nums) return 0;
        if (nums.length < 3) return nums.length;
        
        let writer = 0;
        let reader = 0;
        while (reader < nums.length) {
            let [newReader, count, curNum] = read(nums, reader);
            let newWriter = write(nums, writer, curNum, Math.min(count, 2));
            reader = newReader;
            writer = newWriter;
        }
        
        return writer;
        
        function read(nums, reader) {
            let count = 0;
            let curNum = nums[reader];
            while (reader < nums.length) {
                if (nums[reader] !== curNum) break;
                reader++;
                count++;
            }
            return [reader, count, curNum];
        }
        
        function write(nums, writer, num, count) {
            while (count--) {
                nums[writer++] = num;
            }
            return writer;
        }
    };

### 2. 官方solution👍

    var removeDuplicates = function(nums) {
        let j = 1;
        let count = 1;
        for (let i = 1; i < nums.length; i++) {
            if (nums[i] === nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            
            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        return j;
    };

### 3. 大牛 👍👍👍

    var removeDuplicates = function(nums) {
        let i = 0;
        for (let n of nums) {
            if (i < 2 || n > nums[i - 2]) nums[i++] = n;
        }
        return i;
    };

# 25. Reverse Nodes in k-Group

Last visited: Nov 28, 2019
Star: ⭐️
Tag: LL
Type: Hard
🚴‍♀️Count: 2

## 复习思想：找最小重复单元 - 万变不离其宗

- if else
- loop
- recursion

## 本题重复单元

- 微操：链表指针操作
- 思想：递归 - 假设后面的操作都完成了，现在需要做什么

## 我的实现

### 1. 非递归

    var reverseKGroup = function(head, k) {
        const dummy = new ListNode(0);
        dummy.next = head;
        let groupPrev = dummy;
        while (groupPrev) {
            groupPrev = reverseNextGroup(groupPrev, k);
        }
    
        return dummy.next;
    
    
        function reverseNextGroup(groupPrev, k) {
            if (!verify(groupPrev, k)) return null;
            
            const nextPrev = groupPrev.next;
            const [groupNext, groupHead] = reverseKNodes(groupPrev.next, null, k);
            
            groupPrev.next = groupHead;
            nextPrev.next = groupNext;
    
            return nextPrev;
        }
    
        function verify(node, k) {
            while (k) {
                if (!node || !node.next) break;
                node = node.next;
                k--;
            }
            return k === 0;
        }
    
        function reverseKNodes(curt, prev, k) {
            if (k === 0) return [curt, prev];
            let next = curt.next;
            curt.next = prev;
            return reverseKNodes(next, curt, k - 1);
        }
    };

### 2. 递归

    var reverseKGroup = function(head, k) {
        let [groupHead, temp] = [head, k];
        while (temp) { // verify
            if (!head) return groupHead;
            head = head.next;
            temp--;
        }
    
        const nextGroupHead = reverseKGroup(head, k);
        let prev = nextGroupHead;
        let curt = groupHead;
        temp = k;
        while (temp) {
            let next = curt.next;
            curt.next = prev;
            [prev, curt] = [curt, next];
            temp--;
        }
    
        return prev;
    }

## 代码实现比较

### 1. Top rated Java (recursion)

相较我的实现：

- 没有太多变量的重复命名（有利有弊 - 易晕易出错）
- 旁支的逻辑判断比较少

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }

### 2. 派森Top rated (recursion) 👍

相较我的实现

- 子函数抽象的好
- 逻辑判断清晰，变量命名合理

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
            count, node = 0, head
            while node and count < k:
                node = node.next
                count += 1
            if count < k: return head
            
            new_head, next_head = self.reverse(head, count) # <-!!!
            head.next = self.reverseKGroup(new_head, k)
            
            return next_head
    
        
        def reverse(self, head, count):
            prev, cur, nxt = None, head, head
            while count > 0:
                nxt = cur.next
                cur.next = prev
                prev, cur = cur, nxt
                count -= 1
                
            return (cur, prev)

### 3. iteration另解

学习这种解释、图示方法

    /** 
         * Reverse a link list between begin and end exclusively
         * an example:
         * a linked list:
         * 0->1->2->3->4->5->6
         * |           |   
         * begin       end
         * after call begin = reverse(begin, end)
         * 
         * 0->3->2->1->4->5->6
         *          |  |
         *      begin end
         * @return the reversed list's 'begin' node, which is the precedence of node end
         */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
    
        int i = 0;
        while (head != null){
        	i++;
        	if (i % k == 0){
        		begin = reverse(begin, head.next);
        		head = begin.next;
        	} else {
        		head = head.next;
        	}
        }
        return dummyhead.next;
        
    }
    
    public ListNode reverse(ListNode begin, ListNode end){
    	ListNode curr = begin.next;
    	ListNode next, first;
    	ListNode prev = begin;
    	first = curr;
    	while (curr != end){
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	begin.next = prev;
    	first.next = curr;
    	return first;
    }

复做

    var reverseKGroup = function(head, k) {
        if (!head || k === 1) return head;
        
        const D = new ListNode(0);
        D.next = head;
        
        let node = D;
        let P = D;
        let count = 0;
        while (node) {
            if (count && count % k === 0) {
                P = reverseAndReturnNewTail(P, node.next);
                node = P;
            }
            node = node.next;
            count++;
        }
        
        return D.next;
        
        function reverseAndReturnNewTail(P, N) {
            let curt = P.next;
            let prev = N;
            let newTail = curt;
            while (curt !== N) {
                let next = curt.next;
                curt.next = prev;
                [prev, curt] = [curt, next];
            }
            
            P.next = prev;
            return newTail;
        }
    };