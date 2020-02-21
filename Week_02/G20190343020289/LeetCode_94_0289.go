package G20190343020289

//94. 二叉树的中序遍历
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	// 递归
	//if root == nil {
	//	return nil
	//}
	//leftNode := inorderTraversal(root.Left)
	//rightNode := inorderTraversal(root.Right)
	//return append(append(leftNode, root.Val), rightNode...)

	// 迭代
	if root == nil {
		return nil
	}
	res := make([]int, 0)
	stack := make([]*TreeNode, 0)
	cur := root
	for cur != nil || len(stack) != 0 {
		if cur != nil {
			// 入栈
			stack = append(stack, cur)
			cur = cur.Left
		} else {
			// cur==nil 说明没有下一级节点，出栈
			// 栈先入后出，取最后一个元素
			node := stack[len(stack)-1]
			// 模拟出栈
			stack = stack[:len(stack)-1]
			res = append(res, node.Val)
			cur = node.Right
		}
	}
	return res
}
