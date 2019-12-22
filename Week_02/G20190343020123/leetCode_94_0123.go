package main

import "fmt"

//94. 二叉树的中序遍历
//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//中序遍历
func inorderTranversal(node *TreeNode) []int {
	result := make([]int, 0)
	_inorderTranversal(node, &result)
	return result
}
func _inorderTranversal(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	_inorderTranversal(node.Left, result)
	*result = append(*result, node.Val)
	_inorderTranversal(node.Right, result)
}

func main() {
	head := &TreeNode{Val: 1}
	head.Left = &TreeNode{Val: 4}
	head.Left.Left = &TreeNode{Val: 5}
	head.Right = &TreeNode{Val: 2}
	head.Right.Left = &TreeNode{Val: 3}

	result := inorderTranversal(head)
	fmt.Printf("result: %v\n", result)
}
