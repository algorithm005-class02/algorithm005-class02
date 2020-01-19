学习笔记

### 字典树的

#### 概念

- 字典树，即 Trie 树，又称单词 查找树或键树，是一种树形结 构。典型应用是用于统计和排 序大量的字符串(但不仅限于 字符串)，所以经常被搜索引 擎系统用于文本词频统计。
它的优点是:最大限度地减少 无谓的字符串比较，查询效率 比哈希表高。

#### 优点

- 最大限度地减少 无谓的字符串比较，查询效率 比哈希表高。

#### 基本性质

- 结点本身不存完整单词;
- 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的 字符串;
- 每个结点的所有子结点路径代表的字符都不相同。

#### 核心思想

- Trie 树的核心思想是空间换时间。
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### 并查集（Disjoint Set）

#### 适用场景

- 组团、配对问题
- Group or not ?

#### 基本操作

- makeSet(s):建立一个新的并查集，其中包含 s 个单元素集合。
- unionSet(x, y):把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
的集合不相交，如果相交则不合并。
- find(x):找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

```java
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
return p; }
  public void union(int p, int q) {
   int rootP = find(p);
   int rootQ = find(q);
   if (rootP == rootQ) return;
   parent[rootP] = rootQ;
count--; }
}
```
