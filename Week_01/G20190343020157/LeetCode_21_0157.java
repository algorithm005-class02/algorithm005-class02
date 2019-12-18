/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建一个链表，然后将两个依次向后遍历，比较较小的值放入新的链表，并将指针向后移
        // 执行用时 1ms，内存消耗 39.5 MB
        ListNode resultList = null;
        if (l1 == null && l2 == null) return null;
        else if (l1 != null && l2 == null) {
            resultList = new ListNode(l1.val);
            l1 =l1.next;
        }
        else if(l2 != null && l1 == null){
            resultList = new ListNode(l2.val); 
            l2 =l2.next;
        }else {
            resultList = new ListNode(l1.val);
        }
        if(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                resultList.val = l1.val;
                l1 = l1.next;
            }else{
                resultList.val = l2.val;
                l2 = l2.next;
            }
        }
        ListNode result = resultList;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode tempNode = new ListNode(l1.val);
                resultList.next = tempNode;
                resultList = resultList.next;
                l1 = l1.next;
            }else if (l1.val > l2.val){
                ListNode tempNode = new ListNode(l2.val);
                resultList.next = tempNode;
                resultList = resultList.next;
                l2 = l2.next;
            }else{
                ListNode tempNode = new ListNode(l1.val);
                ListNode tempNode2 = new ListNode(l2.val);
                tempNode.next = tempNode2;
                resultList.next = tempNode;
                resultList = tempNode2;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(l1 == null && l2 !=null)resultList.next = l2;
        else if (l2 == null && l1 !=null)resultList.next = l1;
        return result;




        //第一次优化？
        
    }
}