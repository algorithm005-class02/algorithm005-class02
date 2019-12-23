package main

import "fmt"

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var ret *TreeNode
	roadP := search(root, p)
	roadQ := search(root, q)

	for i, j := len(roadP)-1, len(roadQ)-1; i >= 0 && j >= 0; i, j = i-1, j-1 {
		if roadP[i] == roadQ[j] {
			ret = roadP[i]
		} else {
			break
		}
	}

	return ret
}

func search(root, target *TreeNode) []*TreeNode {
	roadMap := []*TreeNode{}
	if recursionInorderSearch(root, target, &roadMap) {
		return roadMap
	}

	return []*TreeNode{}
}

func recursionInorderSearch(root, target *TreeNode, roadMap *[]*TreeNode) bool {
	if nil == root || nil == target {
		return false
	}

	if root == target {
		*roadMap = append(*roadMap, root)
		return true
	}

	if nil != root.Left && recursionInorderSearch(root.Left, target, roadMap) {
		*roadMap = append(*roadMap, root)
		return true
	}

	if nil != root.Right && recursionInorderSearch(root.Right, target, roadMap) {
		*roadMap = append(*roadMap, root)
		return true
	}

	return false
}

func testLowestCommonAncestor() {
	zero := &TreeNode{Val: 0, Left: nil, Right: nil}
	one := &TreeNode{Val: 1, Left: nil, Right: nil}
	two := &TreeNode{Val: 2, Left: nil, Right: nil}
	three := &TreeNode{Val: 3, Left: nil, Right: nil}
	four := &TreeNode{Val: 4, Left: nil, Right: nil}
	five := &TreeNode{Val: 5, Left: nil, Right: nil}
	six := &TreeNode{Val: 6, Left: nil, Right: nil}
	seven := &TreeNode{Val: 7, Left: nil, Right: nil}
	eight := &TreeNode{Val: 8, Left: nil, Right: nil}

	three.Left = five
	three.Right = one

	five.Left = six
	five.Right = two

	one.Left = zero
	one.Right = eight

	two.Left = seven
	two.Right = four

	ancestor := lowestCommonAncestor(three, seven, eight)
	if nil != ancestor {
		fmt.Println(ancestor.Val)
	} else {
		fmt.Println("none")
	}
}
