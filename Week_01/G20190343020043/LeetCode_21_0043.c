struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if (l1 == NULL && l2 == NULL) {
        return NULL;
    } else if (l1 == NULL && l2 != NULL) {
        return l2;
    } else if (l1 != NULL && l2 == NULL) {
        return l1;
    } else {
        struct ListNode* currentPointer1 = l1;
        struct ListNode* currentPointer2 = l2;
        struct ListNode* frontPointer = NULL;
        struct ListNode* behindPointer = NULL;
        while (currentPointer1 != NULL && currentPointer2 != NULL) {
            if (currentPointer2 -> val < currentPointer1 -> val) {
                behindPointer = currentPointer2 -> next;
                if (frontPointer == NULL) {
                    currentPointer2 -> next = currentPointer1;
                    frontPointer = currentPointer2;  
                    l1 = frontPointer;  
                } else {
                    currentPointer2 -> next = currentPointer1;
                    frontPointer -> next = currentPointer2;
                    frontPointer = currentPointer2;
                }
                currentPointer2 = behindPointer;
            } else {
                frontPointer = currentPointer1;
                currentPointer1 = currentPointer1 -> next;
            }
        }
        if (currentPointer1 == NULL) {
            frontPointer -> next = currentPointer2;
        }  
        return l1;
    }
}