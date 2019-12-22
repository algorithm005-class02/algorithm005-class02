package main

// NAryTreeNode Definition for a n ary tree node
type NAryTreeNode struct {
	Val      int
	Children []*NAryTreeNode
}

func levelorder(root *NAryTreeNode) [][]int {
	ret := [][]int{}
	if nil == root {
		return ret
	}

	que := make(chan *NAryTreeNode, 5000)
	que <- root
	for len(que) > 0 {
		oneLevelNodes := []int{}
		for loopCount := len(que); loopCount > 0; loopCount-- {
			curNode := <-que
			oneLevelNodes = append(oneLevelNodes, curNode.Val)
			for _, node := range curNode.Children {
				que <- node
			}
		}
		ret = append(ret, oneLevelNodes)
	}

	return ret
}

/*
func main() {
	one := &NAryTreeNode{Val: 1, Children: []*NAryTreeNode{}}
	two := &NAryTreeNode{Val: 2, Children: []*NAryTreeNode{}}
	three := &NAryTreeNode{Val: 3, Children: []*NAryTreeNode{}}
	four := &NAryTreeNode{Val: 4, Children: []*NAryTreeNode{}}
	five := &NAryTreeNode{Val: 5, Children: []*NAryTreeNode{}}
	six := &NAryTreeNode{Val: 6, Children: []*NAryTreeNode{}}
	seven := &NAryTreeNode{Val: 7, Children: []*NAryTreeNode{}}
	eight := &NAryTreeNode{Val: 8, Children: []*NAryTreeNode{}}

	one.Children = append(one.Children, three)
	one.Children = append(one.Children, two)
	one.Children = append(one.Children, four)

	three.Children = append(three.Children, five)
	three.Children = append(three.Children, six)

	two.Children = append(two.Children, seven)

	seven.Children = append(seven.Children, eight)

	fmt.Println(levelorder(one))
}
*/
