package G20190343020289

//144. 二叉树的前序遍历
func preorderTraversal(root *TreeNode) []int {
	// 递归
	//if root == nil {
	//	return nil
	//}
	//r1 := preorderTraversal(root.Left)
	//r2 := preorderTraversal(root.Right)
	//return append(append([]int{root.Val}, r1...), r2...)

	// 迭代
	// 使用切片模拟栈，每次循环根节点先出栈，
	// 先入右子节点，再入左子节点
	res, stack := []int{}, []*TreeNode{}
	if root != nil {
		stack = append(stack, root)
	}
	for len(stack) > 0 {
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		res = append(res, node.Val)
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
		if node.Left != nil {
			stack = append(stack, node.Left)
		}
	}
	return res
}
