### 图
**图由边的集合及顶点的集合组成**
**顶点的权重称为成本**
**有序图**如果一个图的顶点对是有序的，则称为有向图。在对有向图中的顶点对排序后，可以在两个顶点之间绘制一个箭头。有向图表明了顶点的流向。
**无序图**如果图是无序的，则称为无序图
**路径**图中一系列顶点构成路径，路径中所有顶点都由边连接。由指向自身的顶点组成的路径称为环，环的长度为0。**圈**是至少一条边，第一个点和最后一个点相同。
无论是有向图还是 无向图，只要是没有重复边或重复顶点的圈，就是一个简单圈。除了第一个和最后一个顶 点以外，路径的其他顶点有重复的圈称为平凡圈。
如果两个顶点之间有路径，那么这两个顶点就是强连通的，反之亦然。如果有向图的所有 的顶点都是强连通的，那么这个有向图也是强连通的。
<pre><code>
// 顶点
function Vertex(label) {
  this.label = label
}
</code></pre>
<pre><code>
// 边(邻接表|邻接矩阵)
</code></pre>
<pre><code>
// 构图
function Graph(v) {
  this.vertices = v
  this.edges = 0
  this.adj = []
  for (var i = 0; i < this.vertices; i++) {
    this.adj[i] = []
    this.adj[i].push("")
  }
  this.addEdge = addEdge
  this.toString = toString 
  this.ShowGraph = showGraph
}
</code></pre>
<pre><code>
function addEdge(v, w) {
  this.adj[v].push(w)
  this.adj[w].push(v)
  this.edges++
}
</code></pre>
<pre><code>
function showGraph() {
  for (var i = 0; i < this.vertices; ++i) {
    let str = i + '->'
    for (var j = 0; j < this.vertices; j++) {
      str = filter(this.adj[i][j]) + ' '
    }
    console.log(str)
  }
}
function filter(param) {
  if (param == null || param == undefined) {
    return ''
  }
  return param
}
</code></pre>
### 分治、回溯
### 深度优先搜索、广度优先搜索
##### 深度搜索
深度优先搜索包括从一条路径的起始顶点开始追溯，直到到达最后一个顶点，然后回溯，继续追溯下一条路径，直到到达最后的顶点，如此反复，直到没有路径为止
**思路：**访问一个没有访问过的顶点，将它标记为已访问，再递归地 去访问在初始顶点的邻接表中其他没有访问过的顶点。
<pre><code>
// 在Graph中添加一个数组，用来存储访问过的顶点，将所有元素值初始化为false
this.marked = []
for (var i = 0; i < this.vertices; ++i) {
  this.marked[i] = false
}
</code></pre>
<pre><code>
function dfs(v) {
  this.marked[v] = true
  if (this.adj[v] != undefined) {
    console.log(v)
    for (var w of this.adj[v])
    if (!this.marked[w]) {
      this.dfs(w)
    }
  }
}
</code></pre>
##### 广度优先搜索
广度优先搜索从第一个顶点开始，尝试访问尽可能靠近它的顶点。本质上，这种搜索在图 上是逐层移动的，首先检查最靠近第一个顶点的层，再逐渐向下移动到离起始顶点最远的层。
使用了抽象的队列而不是数组来对已访问过的顶点进行排序。
**思路**
(1) 查找与当前顶点相邻的未访问顶点，将其添加到已访问顶点列表及队列中； 
(2) 从图中取出下一个顶点 v，添加到已访问的顶点列表； 
(3) 将所有与 v 相邻的未访问顶点添加到队列。
<pre><code>
function bfs(s) {
  var queue = []
  this.marked[s] = true
  queue.push(s)
  while (queue.length > 0) {
    var v = queue.shift()
    if (v == undefined) {
      console.log(v)
    }
    for(var w of this.adj[v]) {
      if(!this.marked[w]) {
        this.edgeTo[w] = v
        this.marked[w] = true
        queue.push(w)
      }
    }
  }
}
</code></pre>

**最短路径**
在执行广度优先搜索时，会自动查找从一个顶点到另一个顶点相连最短路径。
<pre><code>
//添加到Graph类,保存一个顶点到下一个顶点的所有边
this.edgeTo = []
this.pathTo = pathTo
this.hasPathTo = hasPathTo
</code></pre>
<pre><code>
function pathTo(v) {
  var source = 0;
  if (!this.hasPathTo(v)) {
    return undefined
  }
  var path = []
  for (var i = v; i != source; i = this.edgeTo[i]) {
    path.push(i)
  }
  path.push(s)
  return path
}
</code></pre>
<pre><code>
function hasPathTo(v) {
  return this.marked[v]
}
</code></pre>
### 贪心算法
### 二分查找