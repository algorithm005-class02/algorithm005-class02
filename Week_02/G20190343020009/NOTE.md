# 哈希表

### 概念

它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。

 这个映射函数叫作散列函数（Hash Function），存放记录的数组 叫作哈希表（或散列表）。

不好的散列函数会让哈希表退化成链表

### 工程实践

1. 电话号码簿
2. 用户信息表
3. 缓存（LRU Cache） 
4. 键值对存储（Redis）



### 补充

养成收藏精选代码的习惯 会写才是自己的 做笔记帮助学习

# 树

链表分叉一下就是树，树连通了就是图

Linked List 是特殊化的 Tree Tree 是特殊化的 Graph



### 二叉树遍历

1.前序（Pre-order）：根-左-右 

2.中序（In-order）：左-根-右 

3.后序（Post-order）：左-右-根



```python
def preorder(self, root):
if root:
 self.traverse_path.append(root.val)
 self.preorder(root.left)
 self.preorder(root.right)
def inorder(self, root):
if root:
 self.inorder(root.left)
 self.traverse_path.append(root.val)
 self.inorder(root.right)
def postorder(self, root):
if root:
 self.postorder(root.left)
 self.postorder(root.right)
 self.traverse_path.append(root.val)
```





### 二叉搜索树

二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、 排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树： 

1. 左子树上所有结点的值均小于它的根结点的值

2. 右子树上所有结点的值均大于它的根结点的值

3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！） 

   

   中序遍历：升序排列



树的面试题 解法一般都是递归

因为 每个子树拿出来又是一个树，数据结构没差，向下级遍历就相当于不断自我分解，所以特别适合用递归

# 递归

递归模板代码

```python
def recursion(level, param1, param2, ...):
# recursion terminator 第一步 终结条件
if level > MAX_LEVEL:
 process_result
 return
# process logic in current level 第二步 处理当前层逻辑
process(level, data...)
# drill down 第三步 到下一层
self.recursion(level + 1, p1, ...)
# reverse the current level status if needed 第四步  清理当前层
```





### 思维要点 

1. 不要人肉进行递归（最大误区）  直接套模板写函数 不要画分解步骤
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）  因为循环是所有代码的基础 递归也是一种循环
3. 数学归纳法思维  1、2成立 n也成立