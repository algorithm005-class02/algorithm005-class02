package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	test := TreeNode{
		Val: 9,
		Left: &TreeNode{
			Val: 7,
			Left: &TreeNode{
				Val:   1,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   8,
				Left:  nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val:  16,
			Left: nil,
			Right: &TreeNode{
				Val:   20,
				Left:  nil,
				Right: nil,
			},
		},
	}
	fmt.Println(preorderTraversal(&test))
}

type Stack struct {
	data []*TreeNode
}

func (stack *Stack) push(node *TreeNode) {
	stack.data = append(stack.data, node)
}

func (stack *Stack) pop() *TreeNode {
	if stack.isEmpty() {
		return nil
	}
	temp := stack.data[len(stack.data)-1]
	stack.data = stack.data[:len(stack.data)-1]
	return temp
}

func (stack *Stack) peek() *TreeNode {
	if stack.isEmpty() {
		return nil
	}
	return stack.data[len(stack.data)-1]
}

func (stack Stack) isEmpty() bool {
	return len(stack.data) == 0
}

func preorderTraversal(root *TreeNode) []int {
	if root == nil {
		return nil
	}
	visited := make(map[*TreeNode]struct{})
	stack := Stack{data: []*TreeNode{root}}
	res := []int{}
	for !stack.isEmpty() {
		node := stack.pop()
		if _, ok := visited[node]; ok {
			res = append(res, node.Val)
		} else {
			if node.Right != nil {
				stack.push(node.Right)
			}
			if node.Left != nil {
				stack.push(node.Left)
			}
			stack.push(node)
			visited[node] = struct{}{}
		}
	}
	return res
}
