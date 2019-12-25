package leetcode

// 题目地址 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
// 据一棵树的前序遍历与中序遍历构造二叉树。

// 注意:
// 你可以假设树中没有重复的元素。

// 例如，给出

// 前序遍历 preorder = [3,9,20,15,7]
// 中序遍历 inorder = [9,3,15,20,7]

// 返回如下的二叉树：

//     3
//    / \
//   9  20
//     /  \
//    15   7

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
	m := make(map[int]int)
	for i, v := range inorder {
		m[v] = i
	}
	return recursion(preorder, m, 0, len(preorder)-1, 0)
}

// recursion
// pi preorder 开始位置 pj preorder 结束位置 ii 中序遍历数组开始的位置
// pi+m[preorder[pi]]-ii 左子树个数
func recursion(preorder []int, m map[int]int, pi, pj, ii int) *TreeNode {
	if pi > pj {
		return nil
	}
	root := &TreeNode{Val: preorder[pi]}
	root.Left = recursion(preorder, m, pi+1, pi+m[preorder[pi]]-ii, ii)
	root.Right = recursion(preorder, m, pi+m[preorder[pi]]-ii+1, pj, m[preorder[pi]]+1)
	return root
}

// @lc code=end
