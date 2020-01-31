package leetcode

/*
 * @lc app=leetcode.cn id=547 lang=golang
 *
 * [547] 朋友圈
 */

// @lc code=start
func findCircleNum(M [][]int) int {
	// DFS 方式
	// visited := make([]int, len(M), len(M))
	// count := 0
	// for i := range M {
	// 	if visited[i] == 0 {
	// 		friendDFS(M, visited, i)
	// 		count++
	// 	}
	// }
	// return count

	// 并查集
	n := len(M)
	uf := NewUnionFind(n)
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if M[i][j] == 1 {
				uf.Union(i, j)
			}
		}
	}
	return uf.Count()
}

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

func friendDFS(M [][]int, visited []int, i int) {
	for j := range M {
		if M[i][j] == 1 && visited[j] == 0 {
			visited[j] = 1
			friendDFS(M, visited, j)
		}
	}
}

// @lc code=end
