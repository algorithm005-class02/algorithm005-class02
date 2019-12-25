package G20190343020289

type Node struct {
	val      int
	children []Node
}

//589. N叉树的前序遍历
func preorder(root *Node) []int {
	if root.children == nil {
		return nil
	}
	temp := make([]int, 0)
	for _, v := range root.children {
		temp = append(temp, preorder(&v)...)
	}
	return append([]int{root.val}, temp...)
}
