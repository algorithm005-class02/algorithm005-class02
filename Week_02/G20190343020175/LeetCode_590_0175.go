package main

// NAryTreeNode Definition for a n ary tree node
type NAryTreeNode struct {
	Val      int
	Children []*NAryTreeNode
}

func postorderTraversal(root *NAryTreeNode) []int {
	ret := []int{}
	recursionPostorderTraversal(root, &ret)
	return ret
}

func recursionPostorderTraversal(root *NAryTreeNode, o *[]int) {
	if nil == root {
		return
	}

	for _, node := range root.Children {
		recursionPostorderTraversal(node, o)
	}
	*o = append(*o, root.Val)
}

/*
func main() {
	one := &NAryTreeNode{Val: 1, Children: []*NAryTreeNode{}}
	two := &NAryTreeNode{Val: 2, Children: []*NAryTreeNode{}}
	three := &NAryTreeNode{Val: 3, Children: []*NAryTreeNode{}}
	four := &NAryTreeNode{Val: 4, Children: []*NAryTreeNode{}}
	five := &NAryTreeNode{Val: 5, Children: []*NAryTreeNode{}}
	six := &NAryTreeNode{Val: 6, Children: []*NAryTreeNode{}}

	one.Children = append(one.Children, three)
	one.Children = append(one.Children, two)
	one.Children = append(one.Children, four)

	three.Children = append(three.Children, five)
	three.Children = append(three.Children, six)

	fmt.Println(postorderTraversal(one))
}
*/
