//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表
package main

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func helper(root *TreeNode, result *[]int) {
	if root != nil {
		helper(root.Left, result)
		*result = append(*result, root.Val)
		helper(root.Right, result)
	}
}

func inorderTraversal(root *TreeNode) []int {
	var result []int
	helper(root, &result)
    return result
}
//leetcode submit region end(Prohibit modification and deletion)
