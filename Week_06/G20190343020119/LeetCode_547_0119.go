type Union struct {
	count  int
	parent []int
}

func findCircleNum(M [][]int) int {

	n := len(M)
	uf := NewUnion(n)
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {

			if M[i][j] == 1 {
				uf.Union(i, j)
			}
		}
	}
	return uf.count
}

func (this *Union) find(p int) int {
	for p != this.parent[p] {
		p = this.parent[p]
		this.parent[p] = this.parent[this.parent[p]]
	}
	return p
}

func NewUnion(n int) *Union {
	parent := make([]int, n, n)
	for i := 0; i < n; i++ {
		parent[i] = i
	}
	return &Union{
		count:  n,
		parent: parent,
	}
}

func dfs(M [][]int, visited []int, i int) {
	for j := range M {
		if M[i][j] == 1 && visited[j] == 0 {
			visited[j] = 1
			dfs(M, visited, j)
		}
	}
}


func (this *UnionFind) Union(p, q int) {
	rp := this.find(p)
	rq := this.find(q)
	if rp != rq {
		this.parent[rp] = rq
		this.count--
	}
}

