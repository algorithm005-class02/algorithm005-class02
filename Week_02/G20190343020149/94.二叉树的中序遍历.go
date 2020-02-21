package leetcode

import "container/list"

// TreeNode Val Left Right
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/*
 * @lc app=leetcode.cn id=94 lang=golang
 *
 * [94] 二叉树的中序遍历
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
func inorderTraversal(root *TreeNode) []int {
	// return dfs(root, []int{})     
	return stackWay(root)
}

// 栈的方式遍历
func stackWay(root *TreeNode) []int {
	stack := list.New()
	result := []int{}
	curNode := root
	for {
		if stack.Len() == 0 && curNode == nil {
			break
		}
		// 左节点入栈
		for {
			if curNode == nil {
				break
			}
			stack.PushBack(curNode)
			curNode = curNode.Left
		}

		// 左节点出栈并放入结果
		// 非叶子节点下一轮遍历该节点的右子树
		if stack.Len() != 0 {
			curNode = (stack.Back().Value).(*TreeNode)
			result = append(result, curNode.Val)
			stack.Remove(stack.Back())
			curNode = curNode.Right
		}
	}
	return result
}

// 递归遍历
func dfs(node *TreeNode, result []int) []int {
	if node == nil {
		return result
	}

	leftResult := dfs(node.Left, result)
	rightResult := dfs(node.Right, result)
	result = append(result, leftResult...)
	result = append(result, node.Val)
	return append(result, rightResult...)
}

// @lc code=end
