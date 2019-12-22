package main

// TreeNode Definition for a binary tree node
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	if nil == root {
		return []int{}
	}

	ret := []int{}
	recursionInorderTraversal(root, &ret)
	return ret
}

func recursionInorderTraversal(root *TreeNode, o *[]int) {
	if nil != root.Left {
		recursionInorderTraversal(root.Left, o)
	}
	*o = append(*o, root.Val)
	if nil != root.Right {
		recursionInorderTraversal(root.Right, o)
	}
}

/*
func main() {
	one := &TreeNode{Val: 1, Left: nil, Right: nil}
	two := &TreeNode{Val: 2, Left: nil, Right: nil}
	three := &TreeNode{Val: 3, Left: nil, Right: nil}

	one.Right = two
	two.Left = three

	fmt.Println(inorderTraversal(one))
}
*/
