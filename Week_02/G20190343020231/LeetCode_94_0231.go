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
	// 迭代
	fmt.Println(inorderTraversal(&test))
	// 递归
	fmt.Println(inorderTraversal2(&test))
}

// 递归
func inorderTraversal2(root *TreeNode) []int {
	res := []int{}
	helper(root, &res)
	//helper2(root, res)
	return res
}

func helper(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	helper(root.Left, res)
	*res = append(*res, root.Val)
	helper(root.Right, res)
}

// 不能这样传参，扩容之后res会变
//func helper2(root *TreeNode, res []int) {
//	if root == nil {
//		return
//	}
//	helper2(root.Left, res)
//	res = append(res, root.Val)
//	helper2(root.Right, res)
//}

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

// 迭代，手动使用栈来模拟递归调用栈
func inorderTraversal(root *TreeNode) []int {
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
			stack.push(node)
			visited[node] = struct{}{}
			if node.Left != nil {
				stack.push(node.Left)
			}
		}
	}
	return res
}
