学习笔记

  字典树，空间换时间，相当于N叉树, 用{}实现直接拿key获取下一棵子树

  #+begin_src python
    class Trie():
        def __init__(self):
            self.root = {}
            self.end_of_word = '#'

        def insert(self, word: str):
            node = self.root
            for c in word:
                if c not in node:
                    node[c] = {}
                node = node[c]
            node[self.end_of_word] = None

        def search(self, word: str) -> bool:
            node = self.root
            for c in word:
                if c not in node: return False
                node = node[c]
            if self.end_of_word in node:
                return True
            return False

        def startsWith(self, prefix: str) -> bool:
            node = self.root
            for c in prefix:
                if c not in node: return False
                node = node[c]
            return True
  #+end_src

  并查集，多个集合，每个集合有一个代表；可将每个集合压缩为两层的树。

  #+begin_src python
    class UnionFind():
        def __init__(self, n):
            self.count = n
            self.parent = [i for i in range(n)]

        def union(self, i, j):
            i_parent = self.find(i)
            j_parent = self.find(j)
            if i_parent != j_parent:
                self.parent[i_parent] = j_parent
                self.count -= 1

        def find(self, i):
            root = i
            while root != self.parent[root]:
                root = self.parent[root]

            while i != self.parent[i]: # compress
                tmp = self.parent[i]
                self.parent[i] = root
                i = tmp

            return i
  #+end_src


  DFS, BFS, 剪枝(寻找重复，将不必要的树枝剪掉); 双向BFS, 缓解单向BFS随着层数的扩展，树枝越来越茂密的问题。有点像数组中双指针的技巧。A*, 启发式算法，聪明的的搜索。
