package main

// TreeNode Definition for a binary tree node
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// NAryTreeNode Definition for a n ary tree node
type NAryTreeNode struct {
	Val      int
	Children []*NAryTreeNode
}
