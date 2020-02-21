package leetcode

/*
 * @lc app=leetcode.cn id=236 lang=golang
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {

	//return findByPath(root, p, q)

	if root == nil || p == root || q == root {
		return root
	}

	left := lowestCommonAncestor(root.Left, p, q)

	right := lowestCommonAncestor(root.Right, p, q)

	if left != nil && right != nil {
		// 左右子树中都找到了目标 说明当前节点是公共祖先
		return root
	} else if left == nil {
		// 两个目标在子树中 子节点就是公共祖先
		return right
	}
	return left
}

// 根据路径查找的方法
func findByPath(root, p, q *TreeNode) *TreeNode {
	var pPath = findPath(root, p, []*TreeNode{})
	var qPath = findPath(root, q, []*TreeNode{})

	pPathLen := len(pPath)
	qPathLen := len(qPath)

	if pPathLen == 0 || qPathLen == 0 {
		return root
	}
	var result *TreeNode = root

	// 检查重合路径
	for i := 1; i < pPathLen && i < qPathLen; i++ {
		nodeP := pPath[i]
		nodeQ := qPath[i]
		if nodeP != nodeQ {
			break
		} else {
			result = nodeP
		}
	}
	return result
}

// 前序遍历找到达目标的路径
func findPath(node, target *TreeNode, path []*TreeNode) []*TreeNode {
	if node == nil {
		return path
	}
	// 找到目标直接返回
	if node == target {
		return append(path, node)
	}
	// 查找左子树
	leftPath := findPath(node.Left, target, path)
	// 查找右子树
	rightPath := findPath(node.Right, target, path)

	if len(leftPath) > 0 {
		// 左子树有结果
		path = append(path, node)
		path = append(path, leftPath...)
	} else if len(rightPath) > 0 {
		// 右子树有结果
		path = append(path, node)
		path = append(path, rightPath...)
	}
	return path
}

// @lc code=end
