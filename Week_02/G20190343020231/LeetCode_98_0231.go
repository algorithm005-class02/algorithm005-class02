package main

// 1. 递归
func isValidBST(root *TreeNode) bool {
	return helper(root, -1<<63, 1<<63-1)
}

// 左子树最大，右子树最小
func helper(root *TreeNode, min, max int) bool {
	if root == nil {
		return true
	}
	if root.Val <= min || root.Val >= max {
		return false
	}
	return helper(root.Left, min, root.Val) && helper(root.Right, root.Val, max)
}


// 2. 中序遍历有序，递归实现
func isValidBST2(root *TreeNode) bool {
	res := []int{}
	helper2(root, &res)
	if len(res) < 2 {
		return true
	}
	// 验证res是有序的236
	for i :=1; i < len(res); i++ {
		if res[i] <= res[i-1] {
			return false
		}
	}
	return true
}

func helper2(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	helper2(root.Left, res)
	*res = append(*res, root.Val)
	helper2(root.Right, res)
}

// 2.1 优化，不使用数组，只保存一个节点
var lastNode *TreeNode
func isValidBST3(root *TreeNode) bool {
	lastNode = nil
	return helper3(root)
}

func helper3(root *TreeNode) bool {
	if root == nil {
		return true
	}
	if !helper3(root.Left) {
		return false
	}
	if lastNode != nil && lastNode.Val >= root.Val {
		return false
	}
	lastNode = root
	return helper3(root.Right)
}
