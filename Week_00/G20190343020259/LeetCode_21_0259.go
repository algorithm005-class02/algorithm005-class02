package G20190343020259

// Definition for singly-linked list.
type ListNode struct {
	Val int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	preHead := &ListNode{
		Val: 0,
		Next: nil,
	}

	preNode := preHead

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			preNode.Next = l1
			l1 = l1.Next
		} else {
			preNode.Next = l2
			l2 = l2.Next
		}
		preNode = preNode.Next
	}

	if l1 == nil {
		preNode.Next = l2
	} else {
		preNode.Next = l1
	}

	return preHead.Next
}
