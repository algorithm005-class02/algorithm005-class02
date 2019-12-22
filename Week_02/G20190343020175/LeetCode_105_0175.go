package main

// TreeNode Definition for a binary tree node
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(preorder []int, inorder []int) *TreeNode {
	return recursionBuildTree(preorder, inorder)
}

func recursionBuildTree(preorder []int, inorder []int) *TreeNode {
	if 0 == len(preorder) && 0 == len(inorder) {
		return nil
	}

	inPos := -1
	for i, v := range inorder {
		if preorder[0] == v {
			inPos = i
		}
	}
	if inPos < 0 {
		return recursionBuildTree(preorder[1:], inorder)
	}

	root := &TreeNode{Val: preorder[0], Left: nil, Right: nil}
	if 1 == len(preorder) || 1 == len(inorder) {
		return root
	}

	prePos := 1
	if 0 < inPos {
		root.Left = recursionBuildTree(preorder[prePos:], inorder[:inPos])
		prePos++
	}
	if len(inorder) > inPos+1 {
		root.Right = recursionBuildTree(preorder[prePos:], inorder[inPos+1:])
	}

	return root
}

/*
func main() {
	buildTree([]int{3, 1, 2, 4}, []int{1, 2, 3, 4})
}
*/
