# 第六周总结
## 13.Trie树和并查集
- 字典树主要讲述3部分内容 字典树的数据结构、核心思想、基本性质
- 回顾前面所学的树的相关数据结构主要有 树的遍历、二叉搜索树
- 并查集适用场景和基本操作，此类型做法不灵活，重点记住模版。
### 1.字典树(Trie树)的数据结构
- 字典树，即 Trie 树，又称单词 查找树或键树，是一种树形结 构。典型应用是用于统计和排 序大量的字符串(但不仅限于 字符串)，所以经常被搜索引 擎系统用于文本词频统计。
- 它的优点是:最大限度地减少 无谓的字符串比较，查询效率 比哈希表高。
#### 基本性质
- 1.结点本身不存完整单词;
- 2.从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
- 3.每个结点的所有子结点路径代表的字符都不相同。
#### 核心思想
- Trie 树的核心思想是空间换时间。
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
#### 重点记忆模版
``` python
class Trie(object):
  
	def __init__(self): 
		self.root = TrieNode()
		self.end_of_word = "#" 
 
	def insert(self, word): 
		node = self.root 
		for char in word: 
			node = node.setdefault(char, {}) 
		node[self.end_of_word] = self.end_of_word 
 
	def search(self, word): 
		node = self.root 
		for char in word: 
			if char not in node: 
				return False 
			node = node[char] 
		return self.end_of_word in node 
 
	def startsWith(self, prefix): 
		node = self.root 
		for char in prefix: 
			if char not in node: 
				return False 
			node = node[char] 
		return True
```
### 2. 并查集(Disjoint Set)
####  适用场景
- 组团、配对问题
- Group or not
####  基本操作
- 1.makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
- 2.unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
的集合不相交，如果相交则不合并。
- 3.find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
#### 重点记忆模版
``` python
def init(p): 
	# for i = 0 .. n: p[i] = i; 
	p = [i for i in range(n)] 
 
def union(self, p, i, j): 
	p1 = self.parent(p, i) 
	p2 = self.parent(p, j) 
	p[p1] = p2 
 
def parent(self, p, i): 
	root = i 
	while p[root] != root: 
		root = p[root] 
	while p[i] != i: # 路径压缩 ?
		x = i; i = p[i]; p[x] = root 
	return root
```
## 14.高级搜索
- 剪枝、双向搜索、启发式搜索(A*)
### 初级搜索
把搜索算法进行优化或者不同方法结合就可以变为要学习的高级算法
- 1.朴素搜索
- 2.优化方式：不重复（fibonacci）、剪枝（生成括号问题）
- 3.搜索方向:
- DFS: depth first search 深度优先搜索 
- BFS: breadth first search 广度优先搜索
- 双向搜索、启发式搜索
  
搜索问题就是树形结合的方法，先把状态树想出来，之后就不不同搜索方法了
### 剪枝
回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当 它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚 至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况: • 找到一个可能存在的正确的答案
• 在尝试了所有可能的分步方法后宣告该问题没有答案 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。
### 双向搜索
就是头尾两端分别用广度搜索，最后中间相汇有重合时就把全部都遍历完了。
#### 双向BFS代码模版
````python
def BFS(graph, start, end):

    visited_begin, visited_end = set(), set()
    queue_begin, queue_end = [start], [end] 

    while queue_begin and queue_end: 
        node_begin = queue_begin.pop()
        node_end = queue_end.pop()  
        visited_begin.add(node_begin)
        visited_end.add(node_end)

        process(node_begin, node_end)
    
        nodes_begin = generate_related_nodes(node_begin)
        nodes_end = generate_related_nodes(node_end)
        
        queue_begin.push(nodes_begin)
        queue_end.push(nodes_end)
````
###  启发式搜索 Heuristic Search (A*)
此部分较难，可以后面再回来多学习
####  估价函数
- 启发式函数: h(n)，它用来评价哪些结点最有希望的是一个我们要找的结 点，h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估 计成本。
- 启发式函数是一种告知搜索方向的方法。它提供了一种明智的方法来猜测 哪个邻居结点会导向一个目标。
#### BFS代码模版
可以用BFS都代码模版类比优化
```python
def AstarSearch(graph, start, end):

	pq = collections.priority_queue() # 优先级 —> 估价函数
	pq.append([start]) 
	visited.add(start)

	while pq: 
		node = pq.pop() # can we add more intelligence here ?
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
        unvisited = [node for node in nodes if node not in visited]
		pq.push(unvisited)
```
## 15. AVL树和红黑树的实现和特性
### AVL树
AVL是发明者名字首字母来命名的，如下1
- 1.发明者 G. M. Adelson-Velsky 和 Evgenii Landis
- 2.Balance Factor(平衡因子): 是它的左子树的高度减去它的右子树的高度(有时相反)。 balance factor = {-1, 0, 1}
- 3.通过旋转操作来进行平衡(四种)
- 4.https://en.wikipedia.org/wiki/Self- balancing_binary_search_tree
### 红黑树 Red-black Tree
红黑树是一种近似平衡的二叉搜索树(Binary Search Tree)，它能够确保任何一 个结点的左右子树的高度差小于两倍。具体来说，红黑树是满足如下条件的二叉搜 索树:
- 每个结点要么是红色，要么是黑色
- 根节点是黑色
- 每个叶节点(NIL节点，空节点)是黑色的。
- 不能有相邻接的两个红色节点
- 从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
#### 关键性质
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
#### 对比AVL树和红黑树
- AVL trees provide faster lookups than Red Black Trees because they are more strictly balanced.
- Red Black Trees provide faster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
- AVL trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
- Red Black Trees are used in most of the language libraries
like map, multimap, multisetin C++ whereas AVL trees are used in databases where faster retrievals are required.