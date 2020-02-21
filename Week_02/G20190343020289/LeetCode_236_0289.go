package G20190343020289

//236. 二叉树的最近公共祖先
/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	return recurTree(root, p, q)
}

func recurTree(cur, p, q *TreeNode) *TreeNode {
	// 遍历左右子数
	// 如果left right都找到，则最近公共祖先为cur
	// 如果left找到，right没找到，则说明另一个节点在left的子节点，所以为left
	// 如果right找到，left没找到，则说明另一个节点在right的子节点，所以为right

	if cur == nil || cur == p || cur == q {
		return cur
	}
	left := recurTree(cur.Left, p, q)
	right := recurTree(cur.Right, p, q)
	if left != nil && right != nil {
		return cur
	} else if right == nil {
		return left
	} else if left == nil {
		return right
	}
	return nil
}
