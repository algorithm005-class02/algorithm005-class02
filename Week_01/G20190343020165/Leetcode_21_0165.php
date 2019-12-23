<?php
/**
	合并两个有序链表
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        $listNode = new ListNode(0);
        $current = $listNode;
        while($l1 != null && $l2 != null){
            if($l1->val > $l2->val){
                $current->next = $l2;
                $l2 = $l2->next;
            }else{
                $current->next = $l1;
                $l1 = $l1->next;
            }
            $current = $current->next;
        }

        $current->next = $l1 == null ? $l2 : $l1;

        return $listNode->next;
    }
}