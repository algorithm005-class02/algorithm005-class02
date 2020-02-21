## 分治和回溯
本质上分治和回溯都是递归。通过寻找重复性解决问题。
分治也就是将一个大问题分解为几个小问题。回溯也即是通过寻找重复性将问题分解为小问题。通过不断向下试错寻找答案。
### 分支代码模板
``` python
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
## 深度搜索和广度搜索
### 深度搜索 DFS
类似回溯，一直向下搜索，遇到终止条件或者搜索到叶子节点则回退到上层节点，从下一个子节点开始继续搜索知道搜索到目标。代码适合递归。
#### 递归版
``` python
visited = set() 
def dfs(node, visited):
    # terminator
    if node in visited: 
    	# already visited
    	return 
	visited.add(node) 
	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)
```
#### 非递归版
``` python
def DFS(self, tree): 
	if tree.root is None: 
		return [] 
	visited, stack = [], [tree.root]
    # 借助栈将每一个节点放入栈，每次从栈顶取出节点
	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```
### 广度搜索 BFS
如树的层次遍历，适合搜索最小步数等问题。
``` python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 
    # 一般借助队列 [第一层根节点，第二层节点1，第二层节点2，第三层节点1，第三层节点2...]
	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```
## 贪心算法
逐步选取最优解，在每一步过程中选择当前步的最优解，从而希望全局最优。（不适用于全部问题，很多问题用贪心算法不能得出全局最优解，要根据具体问题具体分析）
相比于动态规划：贪心算法没有回溯的步骤，忽略之前的结果，动态规划会保存之前结果，可以通过回溯选取最优解。
## 二分查找
### 代码模板
``` python
# 1.初始化范围
left, right = 0, len(array) - 1

# 2.循环
while left < right:
    #2.1 计算中位数 (left + right)  // 2 在强类型语言中可能发生int越界
    mid = left + (right - left) // 2 # 右中位数
    # 找到目标，条件可能是其他
    if array[mid] == target:
        return result
    # 向右规约
    elif array[mid] < target:
        left = mid + 1
    # 向左规约
    else:
        right = mid - 1
# 注意不同while条件，不同题目返回边界不同
return right
```