package main

func main() {

}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}
	val := preorder[0]
	idx := index(inorder, val)
	node := &TreeNode{Val: val}
	node.Left = buildTree(preorder[1:idx+1], inorder[:idx])
	node.Right = buildTree(preorder[idx+1:], inorder[idx+1:])
	return node
}

func index(array []int, val int) int {
	for i := 0; i < len(array); i++ {
		if array[i] == val {
			return i
		}
	}
	return -1
}
