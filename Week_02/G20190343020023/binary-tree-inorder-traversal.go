/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func inorderTraversal(root *TreeNode) []int {
    var result []int
    if root == nil {
        return result
    }
    return helper(root, result)
}

func helper(root *TreeNode, result []int) []int {
    if root.Left != nil {
        result = helper(root.Left, result)
    }
    result = append(result, root.Val)
    if root.Right != nil {
        result = helper(root.Right, result)
    }
    return result
}