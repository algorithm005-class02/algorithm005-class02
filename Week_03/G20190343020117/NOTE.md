# 第三周总结
## 8.分治和回溯
- 分治、回溯本质上就是递归，是一种复杂点的递归，最后它的本质都是找到它的重复性。
### 分治 Divide & Conquer
- 分治，就是把大问题分解成若干可重复的小问题，最后再把小问题组合起来的思想。
### 分治代码模版

```python
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
   …

   # process and generate the final result 
   result = process_result(subresult1, subresult2, subresult3, …)
	
   # revert the current level states
```

### 回溯 Backtracking
- 定义：回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程 中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将 取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问 题的答案。
- 回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种 情况:
找到一个可能存在的正确的答案;
在尝试了所有可能的分步方法后宣告该问题没有答案。 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。
## 9.深度优先搜索和广度优先搜索
搜索一般是暴力搜索或者只能搜索，这一个讲到的是暴力搜索。
- 遍历搜索
在树(图/状态集)中寻找特定结点
- 搜索-遍历
1. 每个节点都要访问一次
2. 每个节点仅仅要访问一次
3. 对于节点的访问顺序不限
   深度优先:depth first search
   广度优先:breadth first search

### DFS 代码模板 Depth first search
- 递归写法
```python
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
- 非递归写法
```python
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
### BFS 代码模板 Breadth first search
```python
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
### 总结
深度优先搜索和广度优先搜索一种固化的程序，类似模版一样，记住就好。它的本质无非就是把所有结点都访问一遍，按结点的访问次序不一样分为深度优先和广度优先，写的时候可以按递归或者循环的方式，递归比较简单，因为程序用系统的话给你自动去维护了一个栈缪氏它函数的调用栈。而在用广度优先搜索的在这里的话程序就没法帮你去维护queue这样的数据结构，所以你必须手动维护queue，当然也可手动写一个栈，类似模版的写法。
## 10.贪心算法 Greedy
### 定义
- 贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有 利)的选择，从而希望导致结果是全局最好或最优的算法。
- 贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择， 不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前 进行选择，有回退功能。
- 贪心法可以解决一些最优化问题，如:求图中的最小生成树、求哈夫曼编码 等。然而对于工程和生活中的问题，贪心法一般不能得到我们所要求的答 案。
- 一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最 好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心 法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。
### 贪心、回溯和动态规划的对比
- 贪心是当下做局部最优判断
- 回溯是能够回退
- 动态规划是最优判断+回退
### 适用贪心算法的场景
简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终 问题的最优解。这种子问题最优解称为最优子结构。
## 11.二分查找 Binary Search
### 前提条件
1. 目标函数单调性(单调递增或者递减)
2. 存在上下界(bounded)
3. 能够通过索引访问(index accessible)
### 二分查找代码模版
```python
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
## 使用二分查找，寻找一个半有序数组[4, 5, 6, 7, 0, 1, 2]中间无序的地方
