/*
 * @lc app=leetcode.cn id=21 lang=golang
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (58.67%)
 * Likes:    755
 * Dislikes: 0
 * Total Accepted:    152.1K
 * Total Submissions: 259.3K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}

	h := &ListNode{}
	var prev *ListNode = h
	
	for l1 != nil && l2 != nil {
		if l1.Val < l2.Val {
			prev.Next = l1
			prev = prev.Next
			l1 = l1.Next
		} else {
			prev.Next = l2
			prev = prev.Next
			l2 = l2.Next
		}
	}

	if l1 != nil {
		prev.Next = l1
	}
	if l2 != nil {
		prev.Next = l2
	}

	return h.Next
}
// @lc code=end

