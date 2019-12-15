/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
  struct ListNode *mergeNode, *TempNode;

  if (l1 == NULL) 
    return l2;
  if (l2 == NULL)
    return l1;

  mergeNode = malloc(sizeof (struct ListNode));
  TempNode = mergeNode;

  while (l1 != NULL && l2 != NULL) {
    if (l1->val >= l2->val) {
      TempNode->next = l2;
      l2 = l2->next;
    } else {
      TempNode->next = l1;
      l1 = l1->next;
    }
    TempNode = TempNode->next;
    
  }
    
  TempNode->next = l1 == NULL ? l2: l1;

  return mergeNode->next; 
}
