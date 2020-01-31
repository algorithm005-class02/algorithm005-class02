## 学习笔记
### trie树的特性
1. 字典树的数据结构 拆成单个字母，以字母为节点的多叉树
2. 字典树的核心思想 
3. 字典树的基本性质 节点本身不存完整单词，从根节点到某一节点路径上的字母串起来即为完整单词，每个节点不同子路径代表的单词不同  
#### 单词搜索II用tire树方式实现的时间复杂度 ？？？
遍历board O(m*m) tire树查找单词时间复杂度O(k) 在每一个节点会进行DFS时间复杂度为O(4^k) 由于tire树查询的剪枝效果因此只需要对符合要求的词进行完全的DFS 时间复杂度为O(4^n) 总时间复杂度为O(m*m) + O(4^n) n为结果中所有单词的总长度 最坏情况下时间复杂度为 O(m*m*4^k)
### 并查集
#### 适用场景
组团配对问题
#### 基本操作
+ makeSet(s): 新建一个新的并查集，其中包含s个单元素集合
+ unionSet(x,y): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
+ find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于统一集合  
#### 代码模板GO
```go
type UnionFind struct {
	count  int
	parent []int
}

func NewUnionFind(n int) *UnionFind {
	parent := make([]int, n, n)
	for i := 0; i < n; i++ {
		parent[i] = i
	}
	return &UnionFind{
		count:  n,
		parent: parent,
	}
}

func (this *UnionFind) Find(p int) int {
    // 查找统一集合并压缩路径
	for p != this.parent[p] {
		p = this.parent[p]
		this.parent[p] = this.parent[this.parent[p]]
	}
	return p
}

func (this *UnionFind) Count() int {
	return this.count
}

func (this *UnionFind) Union(p, q int) {
	rootP := this.Find(p)
	rootQ := this.Find(q)
	if rootP != rootQ {
		this.parent[rootP] = rootQ
		this.count--
	}
}
```
### 高级搜索
1. 剪枝
2. 双向BFS
3. 启发式搜索（A*）  
### 红黑树和AVL树
#### AVL树
1. 平衡二叉树
2. 每个节点都存平衡因子{-1,0,1}
3. 四种旋转操作
   1. 左左子树(A[-2]->B[-1]->C[0])->右旋
   2. 右右子树(A[2]->B[1]->C[0])->左旋 
   3. 左右子树(A[-2]->B[1]->C[0])->左右旋 
   4. 右左子树(A[2]->B[-1]->C[0])->右左旋
4. 不足需要存储额外信息，且插入调整频繁
#### 红黑树
1. 近似平衡二叉搜索树，任意节点的左右子树高度差小于两倍
2. 每个节点要么红色要么黑色
3. 跟节点是黑色
4. 每个叶子节点（nil）是黑色
5. 不能有相邻的两个红色节点
6. 任意节点到其每个叶子的路径包含相同数目的黑色节点
  
读多写少用AVL其他情况红黑树更合适
