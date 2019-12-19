<?php
// 合并两个有序链表

class Solution
{

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2)
    {
        $listNode = new ListNode(0);
        $prev = $listNode;
        while ($l1 != null && $l2 != null) {
            if ($l1->val >= $l2->val) {
                $prev->next = $l2;
                $l2 = $l2->next;
            } else {
                $prev->next = $l1;
                $l1 = $l1->next;
            }
            $prev = $prev->next;
        }
        $prev->next = $l1 == null ? $l2 : $l1;
        return $listNode->next;
    }
}
