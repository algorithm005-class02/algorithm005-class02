学习笔记

# 回溯
[回溯算法优秀讲解](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/)

回溯算法框架
```cassandraql
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

多叉树的遍历
```cassandraql
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}
```

# 深度优先，广度优先

DFS 递归写法
```cassandraql
visited = set()  
def dfs(node, visited):
   visited.add(node)
   # process current node here.
   ...
  for next_node in node.children():
    if not next_node in visited:
        dfs(next node, visited) 
```
DFS 非递归写法
```cassandraql
def DFS(self, tree):
    if tree.root is None:
        return []
    visited, stack = [], [tree.root]
    while stack:
        node = stack.pop()
        visited.add(node)
        process (node)
        nodes = generate_related_nodes(node)
        stack .push(nodes)
    # other processing work
    ...
```

BFS
```cassandraql
def BFS(graph, start, end):
    queue = []
    queue .append([start])
    visited .add(start)
    while queue:
        node = queue.pop()
        visited .add(node)
        process(node) 
        nodes = generate_related_nodes(node)
        queue .push(nodes)
    # other processing work
    ...
```

题目 102. 二叉树的层次遍历 应用广度优先算法，并需要在广度优先中区分层次

这里注意，广度优先使用的是遍历，而不是迭代（可以思考迭代与深度优先）

# 贪心算法
### 应用场景
问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优.这种子问题最优解称为最优子结构

### 贪心算法与动态规划的不同:
贪心算法对每个子问题的解决方案都做出选择， 不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前 进行选择，有回退功能。

# 二分查找
前提
1. 目标函数的单调性（单调递增或递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

二分查找的代码模板
```cassandraql
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```
