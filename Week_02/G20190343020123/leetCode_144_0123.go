package main

import "fmt"

//二叉树的前序遍历
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func preorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	_preorderTraversal(root, &result)
	return result
}
func _preorderTraversal(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}
	*result = append(*result, root.Val)
	_preorderTraversal(root.Left, result)
	_preorderTraversal(root.Right, result)
}
func main() {
	head := &TreeNode{Val: 1}
	head.Left = &TreeNode{Val: 4}
	head.Left.Left = &TreeNode{Val: 5}
	head.Right = &TreeNode{Val: 2}
	head.Right.Left = &TreeNode{Val: 3}

	result := preorderTraversal(head)
	fmt.Printf("result: %v\n", result)
}
