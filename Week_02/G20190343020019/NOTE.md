# 树的遍历、递归函数的编写模板



## 二叉树的遍历方法

下面记录了两种树的遍历方法，树的遍历非常经典、其遍历方法也很多，但下面两种方法，有其固定的模板，且不仅仅适用于二叉树，也可用于N叉树，是我认为记忆最方便、通用性最好的两种方法。

1. 递归法：

   树这种数据结构非常适合使用遍历，原因很明显：一个树由多个子树构成，而每一个子树也可以看成是独立的树，结构可以说完全一样，因此遍历法是树的遍历方法中最经典的方法。下面记录树的递归遍历的代码模板：

   * 前序遍历

     ```python
     def preorder(self, root):
         if root:
             self.traverse_path.append(root.val)
             self.preorder(root.left)
             self.preorder(root.right)
         
     ```

   * 中序遍历

     ```python
     def inorder(self, root):
         if root:
             self.inorder(root.left)
             self.traverse_path.append(root.val)
             self.inorder(root.right)
     ```

   * 后序遍历

     ```python
     def postorder(self, root):
         if root:
             self.postorder(root.left)
             self.postorder(root.right)
             self.traverse_path.append(root.val)
     ```

2. 标记法:

   标记法核心其实与递归差不多，只是在标记法中我们是手动维护一个栈，并在入栈时标记节点的访问状态：

   * 首次入栈时，标记节点访问状态为 `False` ；
   * 出栈时，根据节点状态进行下一步处理；
     * 若节点访问状态为 `False` ，则该节点的访问状态改为 `True` ，并将该节点与其子节点一一压入栈中，入栈顺序与遍历顺序相反，其子节点因为是首次入栈，所以访问状态均为 `False`；
     * 若节点访问状态为 `True`，则将该节点的值记录到遍历结果中。
   * 循环以上两步操作直到空栈为止，遍历结束

   以 [N叉树的后序遍历](https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/) 为例，其标记法遍历的代码为：

   ```python
   class Solution:
       def postorder(self, root: 'Node') -> List[int]:
           res, stack = [], root and [(root, False)]
           while stack:
               node, is_visited = stack.pop()
               if not node: continue
               if is_visited:
                   res.append(node.val)
               else:
                   stack.append((node, True))
                   for child in node.children[::-1]:
                       stack.append((child, False))
           return res
   ```

   

## 递归函数的编写模板

看到有一条评论说：“每次看到别人写的递归函数，都觉得自己脑子不够用”，表示深有同感。对于一些看上去很复杂的问题，如果能恰当使用递归，最后只要几行代码就能解决。当然递归对内存的消耗也是众所周知的大，学会怎么写递归，但也不能滥用递归。下面记录课上讲的递归模板，遇到递归问题时对应着思考：

```python
def recursion(level, param1, param2, ...):
  	#	1. recursion terminator，递归的终止条件
    if level > MAX_LEVEL:
        process_result
        return

    #	2. process logic in current level，处理当前层逻辑
    process(level, data1, data2, 。。。)
    
    #	3. drill down，下探到下一层
    self.recursion(level + 1, p1, p2, ...)
    
    # 4. reverse the current level status of needed，清理当前层的数据状态（如果需要的话）
    
```

