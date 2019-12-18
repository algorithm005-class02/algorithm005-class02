/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* l = new ListNode(-1);
        ListNode *lR = l;
        while (l1 != nullptr && l2 != nullptr) {
            if (l1->val > l2->val) {
                lR->next = l2;
                l2 = l2->next;
            } else {
                lR->next = l1;
                l1 = l1->next;
            }
            lR = lR->next;
        }
        lR->next = l1 != nullptr ? l1 : l2;
        // if (l1 != nullptr) {
        //     l->next = l1;
        // }
        // if (l2 != nullptr) {
        //     l->next = l2;
        // }
        return l->next;
    }
};
