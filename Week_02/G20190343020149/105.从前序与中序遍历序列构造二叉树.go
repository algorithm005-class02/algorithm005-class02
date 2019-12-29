package leetcode

/*
 * @lc app=leetcode.cn id=105 lang=golang
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	if preorder == nil || len(preorder) == 0 {
		return nil
	}
	root := &TreeNode{
		Val:   preorder[0],
		Left:  nil,
		Right: nil}
	// 根节点的在中序遍历中的位置
	rootInIndex := findIndex(inorder, preorder[0])

	// fmt.Printf("rootInIndex %d", rootInIndex)
	// 中序左子树
	leftInOrder := inorder[0:rootInIndex]
	// 中序右子树
	var rightInOrder []int
	if rootInIndex < len(inorder)-1 {
		rightInOrder = inorder[rootInIndex+1:]
	}
	// 左右前序遍历子节点值
	var leftPreOrder, rightPreOrder []int
	// 存在左子树 这里左子树的长度和rootInIndex的值是相等的 就不用重复算左子树的长度了
	if rootInIndex > 0 {
		leftPreOrder = preorder[1 : rootInIndex+1]
		rightPreOrder = preorder[rootInIndex+1:]
	} else {
		rightPreOrder = preorder[1:]
	}

	root.Left = buildTree(leftPreOrder, leftInOrder)
	root.Right = buildTree(rightPreOrder, rightInOrder)

	return root
}

func findIndex(arr []int, target int) int {
	index := -1
	for i, val := range arr {
		if val == target {
			return i
		}
	}
	return index
}

// @lc code=end
