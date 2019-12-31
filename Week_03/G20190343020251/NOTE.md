# 学习总结
## 分治、回溯
### 分治(Divide&Conquer)代码模板
```
def divide_conquer(problem, param1, param2, ...):
  # recursion terminator
  if problem is None:
    print_result
    return
   
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem, data)
  
  # conquer subproblems
  subresult1 = self.divide_conquer(subproblems[0], p1, ...)
  subresult2 = self.divide_conquer(subproblems[1], p1, ...)
  subresult3 = self.divide_conquer(subproblems[2], p1, ...)
  ...
  
  # process and generate the final result
  result = process_result(subresult1, subresult2, subresult3, ...)
  # revert the current level states
```

### 回溯(Backtracking)
回溯法采用试错的思想，尝试分步的去解决一个问题。通过尝试发现现有的分布答案不能得到有效解时，取消上一步甚至上几步的计算，再通过其他可能的分布解答。

## 深度优先搜索、广度优先搜索
### 搜索-遍历
* 每个节点都要访问一次
* 每个节点仅仅要访问一次
* 对于节点的访问顺序不限
   * 深度优先：depth first search
   * 广度优先：breadth first search

## DFS
### 递归写法
```
visited = set() 

def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
### 非递归写法
```
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

## BFS
### 递归写法
```
visited = set()
def dfs(node, visited):
   visited.add(node)
   
   # process current node here.
   ...
   for next_node in node.children():
     if not next_node in visited:
        dfs(next node, visited)
```

### 非递归写法
```
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

## 贪心法
贪心法是一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。

与动态规划的区别是，贪心法不会回退，且不保存以前运算结果。

## 二分查找
### 前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

### 代码模板
```
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

## 感受
最大的解题感受是，一般只要掌握了解题的模板，对于一些不是特别难的题目，一般就都能解出来。所以刻意练习非常重要。对于二分查找的题目，感觉边界条件有时候控制的还不是很好。


