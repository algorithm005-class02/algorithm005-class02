package G20190343020289

//105. 从前序与中序遍历序列构造二叉树
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	return recurBuild(preorder, inorder)
}

func recurBuild(preorder []int, inorder []int) *TreeNode {
	if len(inorder) == 0 {
		return nil
	}
	// 前序遍历的第一个元素为根节点
	// 中序遍历中该元素左侧为根节点的左子树，右侧为右子树
	node := &TreeNode{Val: preorder[0]}
	inorderIndex := findIndex(inorder, preorder[0])
	node.Left = recurBuild(preorder[1:inorderIndex+1], inorder[:inorderIndex])
	node.Right = recurBuild(preorder[inorderIndex+1:], inorder[inorderIndex+1:])
	return node
}

func findIndex(arr []int, val int) int {
	for k, v := range arr {
		if v == val {
			return k
		}
	}
	return -1
}
