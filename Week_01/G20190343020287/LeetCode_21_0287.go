package leetcode

// 题目地址 https://leetcode-cn.com/problems/merge-two-sorted-lists/
// 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
// 示例:输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4

/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
// Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

// mergeTwoLists1 利用一个递归，合并两个链表
func mergeTwoLists1(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	if l1.Val < l2.Val {
		l1.Next = mergeTwoLists1(l1.Next, l2)
		return l1
	} else {
		l2.Next = mergeTwoLists1(l1, l2.Next)
		return l2
	}
}

// mergeTwoLists2 新建一个链表，将两个链表合并
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	newList := &ListNode{}
	current := newList
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			current.Next = l1
			l1 = l1.Next
		} else {
			current.Next = l2
			l2 = l2.Next
		}
		current = current.Next
	}
	if l1 == nil {
		current.Next = l2
	} else {
		current.Next = l1
	}
	return newList.Next
}

// @lc code=end
