package G20190343020289

//547. 朋友圈
func findCircleNum(M [][]int) int {
	if M == nil || len(M) == 0 {
		return 0
	}
	nfs := NewUnionFind(len(M))
	for i := 0; i < len(M); i++ {
		for j := i + 1; j < len(M); j++ {
			if M[i][j] == 1 {
				nfs.union(i, j)
			}
		}
	}
}

type Node struct {
	parent *Node
}

func NewNode() *Node {
	n := &Node{}
	n.parent = n
	return n
}

func (node *Node) find() *Node {
	if nil == node {
		return node
	}
	if node != node.parent {
		return node.parent.find()
	}
	return node
}

type UnionFind struct {
	count int
	m     []*Node
}

func NewUnionFind(n int) *UnionFind {
	nfs := &UnionFind{
		count: n,
		m:     make([]*Node, n),
	}
	for i := 0; i < n; i++ {
		nfs.m[i] = NewNode()
	}
	return nfs
}

func (nfs *UnionFind) find(n int) *Node {
	return nfs.m[n].find()
}

func (nfs *UnionFind) union(a, b int) {
	s1, s2 := nfs.find(a), nfs.find(b)
	if s1 == s2 {
		return
	}
	s1.parent = s2
	nfs.count--
}
