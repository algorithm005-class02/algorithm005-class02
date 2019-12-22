class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == NULL) return l2;
        if(l2 == NULL) return l1;
        ListNode* dummyH = new ListNode(-1);
        ListNode* cur=dummyH;
        while(l1 != NULL && l2 != NULL) {
            if(l1->val <= l2->val) {
                cur->next = l1;
                l1=l1->next; 
            } else {
                cur->next = l2;
                l2=l2->next;
            }
            cur=cur->next;
        }
        cur->next=(l1!=NULL)?l1:l2;

        ListNode* ret = dummyH->next;
        delete dummyH;
        return ret;
    }
};
