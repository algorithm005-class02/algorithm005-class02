//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //1.暴力求解，时间复杂度O（n）
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode l3 = new ListNode(0);
//        ListNode head = l3;
//        if (l1 == null)    return l2;
//        if (l2 == null)    return l1;
//        while (l1 != null && l2 != null) {
//            if (l1.val > l2.val) {
//                l3.next = l2;
//                l3 = l3.next;
//                l2 = l2.next;
//            } else {
//                l3.next = l1;
//                l3 = l3.next;
//                l1 = l1.next;
//            }
//        }
//        if (l1 == null)    l3.next = l2;
//        if (l2 == null)    l3.next = l1;
//        return head.next;
//    }

    //2.递归求解 时间复杂度O(n)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


