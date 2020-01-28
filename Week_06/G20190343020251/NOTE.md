## 学习总结
### 字典树
Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串，所以经常被搜索引擎系统用于文本词频统计。

优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。(空间换时间，利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的)

基本特性：

1. 结点本身不存完整单词；
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串；
3. 每个节点的所有子结点路径代表的字符都不相同；

#### 代码模板
```
class Trie(object):
  
	def __init__(self): 
		self.root = {} 
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

### 并查集
使用于组团、配对问题。

#### 基本操作
* makeSet(s) : 建立一个新的并查集，其中包含s个单元素集合。
* unionSet(x, y) : 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。 
* find(x) : 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一集合，只要将它们各自的代表比较一下就可以了。

### 代码模板
```
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```


### 高级搜索
* 剪枝
* 双向BFS
* 启发式搜索（A*）

### AVL数
1. 平衡二叉搜索树
2. 每个节点存 balance factor = {-1, 0, 1}
3. 四种旋转操作

不足：结点需要存储额外信息、且调整次数频繁

### Red-black Tree
红黑树是一种近似平衡的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的**左右子树的高度差小于两倍**。

满足以下条件：

* 每个节点要么是红色，要么是黑色
* 根节点是黑色
* 每个叶节点（NIL节点，空节点）是黑色的。
* 不能有相邻的两个红色节点
* 从任一节点到其每个叶子的所有路劲都包含相同数目的黑色节点。

### 对比
* AVL数查找效率比红黑树高。
* 红黑树在插入和删除操作更加高效。
* 红黑树占存储空间更小。
* 红黑树应用广泛，C++标准库，mao，multimap，multiset，数据库都使用红黑树。

