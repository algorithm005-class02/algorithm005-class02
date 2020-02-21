package G20190343020289

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//102. 二叉树的层次遍历
func levelOrder(root *TreeNode) [][]int {
	res := make([][]int, 0)
	//recur(&res, root, 0)
	bfs(&res, root)
	return res
}

//func recur(res *[][]int, startNode *TreeNode, level int) {
//	if startNode == nil {
//		return
//	}
//
//	// 提前在res index为level处占位，以防止index out of range
//	if level >= len(*res) {
//		*res = append(*res, []int{})
//	}
//	currentLevelRes := &(*res)[level]
//	*currentLevelRes = append(*currentLevelRes, startNode.Val)
//	if startNode.Left != nil {
//		recur(res, startNode.Left, level+1)
//	}
//	if startNode.Right != nil {
//		recur(res, startNode.Right, level+1)
//	}
//}

func bfs(res *[][]int, startNode *TreeNode) {
	// 套用模板,迭代
	// 本题需要层级遍历，并按层分组,记录level
	if startNode == nil {
		return
	}
	queue := []*TreeNode{}
	queue = append(queue, startNode)
	level := 0
	for len(queue) > 0 {
		*res = append(*res, []int{})
		currentLen := len(queue)
		for i := 0; i < currentLen; i++ {
			node := queue[0]
			queue = queue[1:]
			currentLevelRes := &(*res)[level]
			*currentLevelRes = append(*currentLevelRes, node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		level++
	}
}
