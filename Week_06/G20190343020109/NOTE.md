学习笔记

Trie 树代码模板：
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


并查集代码模板：
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

BFS 代码模板：
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
    # ...

双向BFS 代码模板：
def BFS(graph, start, end):
    visited_begin = set()
    visited_end = set()
    
    queue_begin = [start]
    queue_end = [end] 

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

    # other processing work 
    # ...


A* 代码模板：
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