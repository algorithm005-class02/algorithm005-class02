package main

import "fmt"

func preorderTraversal(root *TreeNode) []int {
	if nil == root {
		return []int{}
	}

	ret := []int{}
	recursionPreorderTraversal(root, &ret)
	return ret
}

func recursionPreorderTraversal(root *TreeNode, o *[]int) {
	*o = append(*o, root.Val)
	if nil != root.Left {
		recursionPreorderTraversal(root.Left, o)
	}
	if nil != root.Right {
		recursionPreorderTraversal(root.Right, o)
	}
}

func testPreorderTraversal() {
	one := &TreeNode{Val: 1, Left: nil, Right: nil}
	two := &TreeNode{Val: 2, Left: nil, Right: nil}
	three := &TreeNode{Val: 3, Left: nil, Right: nil}

	one.Right = two
	two.Left = three

	fmt.Println(preorderTraversal(one))
}
