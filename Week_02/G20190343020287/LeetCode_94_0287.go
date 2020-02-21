package leetcode

// 题目地址 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
// 给定一个二叉树，返回它的中序 遍历。
// 示例:输入: [1,null,2,3]
//    1
//    \
// 	2
//    /
//   3
// 输出: [1,3,2]

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

 // inorderTraversal 利用递归求解，中序遍历 左根右
func inorderTraversal(root *TreeNode) []int {
	ret := []int{}
	if root == nil {
		return []int{}
	}
	rl := inorderTraversal(root.Left)
	rr := inorderTraversal(root.Right)
	ret = append(ret, rl...)
	ret = append(ret, root.Val)
	ret = append(ret, rr...)
	return ret
}

// @lc code=end
