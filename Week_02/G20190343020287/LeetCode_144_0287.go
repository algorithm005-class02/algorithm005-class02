package leetcode

// 题目地址 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
// 给定一个二叉树，返回它的中序 遍历。
// 示例:输入: [1,null,2,3]
//    1
//    \
// 	2
//    /
//   3
// 输出: [1,2,3]

/*
 * @lc app=leetcode.cn id=144 lang=golang
 *
 * [144] 二叉树的前序遍历
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
func preorderTraversal(root *TreeNode) []int {
	ret := []int{}
	if root == nil {
		return []int{}
	}
	rl := preorderTraversal(root.Left)
	rr := preorderTraversal(root.Right)
	ret = append(ret, root.Val)
	ret = append(ret, rl...)
	ret = append(ret, rr...)
	return ret
}

// @lc code=end
