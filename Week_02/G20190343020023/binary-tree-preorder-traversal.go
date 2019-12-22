/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func preorderTraversal(root *TreeNode) []int {
    var result []int
    if root == nil {
        return result
    }
    return helper(root, result)
}

func helper(root *TreeNode, result []int) []int {
    result = append(result, root.Val)
    if root.Left != nil {
        result = helper(root.Left, result)
    }
    if root.Right != nil {
        result = helper(root.Right, result)
    }
    return result
}