package main

import "fmt"

func main() {
	test := TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val:   6,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val: 2,
				Left: &TreeNode{
					Val:   7,
					Left:  nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val:   4,
					Left:  nil,
					Right: nil,
				},
			},
		},
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val:   0,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   8,
				Left:  nil,
				Right: nil,
			},
		},
	}
	t1 := TreeNode{
		Val:   8,
		Left:  nil,
		Right: nil,
	}
	t2 := TreeNode{
		Val:   0,
		Left:  nil,
		Right: nil,
	}
	fmt.Println(lowestCommonAncestor(&test, &t1, &t2).Val)
	fmt.Println(lowestCommonAncestor2(&test, &t1, &t2).Val)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 1. 直接使用递归
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	// terminator
	if root == nil || p == nil || q == nil || root.Val == p.Val || root.Val == q.Val {
		return root
	}
	// Drill Down
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left == nil {
		return right
	} else if right == nil {
		return left
	}
	return root
}

// 2.深度优先搜索，找path，然后比对
func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	res := []*TreeNode{}
	res2 := []*TreeNode{}
	findPath(root, p, &res)
	findPath(root, q, &res2)
	var lastSame *TreeNode
	for len(res) > 0 && len(res2) > 0 {
		if res[len(res)-1].Val != res2[len(res2)-1].Val {
			break
		}
		lastSame = res[len(res)-1]
		res, res2 = res[:len(res)-1], res2[:len(res2)-1]
	}
	return lastSame
}

// DFS
func findPath(root, target *TreeNode, res *[]*TreeNode) bool {
	// terminator
	if root == nil || target == nil {
		return false
	}

	if root.Val == target.Val {
		*res = append(*res, root)
		return true
	}

	// drill down
	if findPath(root.Left, target, res) || findPath(root.Right, target, res) {
		*res = append(*res, root)
		return true
	}
	return false
}
