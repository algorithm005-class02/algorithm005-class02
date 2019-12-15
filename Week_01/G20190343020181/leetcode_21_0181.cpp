//https://leetcode-cn.com/problems/merge-two-sorted-lists/
#include <vector>

using namespace std;

  //Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 

//自己写的
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if ( l1 == NULL) return l2;
        if ( l2 == NULL) return l1;
        ListNode *p1 = l1;
        ListNode *p1_last = NULL;
        ListNode *p2 = l2;
        ListNode *head = l1;
        for (;p1 != NULL;p1 = p1->next)
        {
            if (p2 == NULL) break;
            if ( p1->val >= p2->val)
            {
                if (head == p1) head = p2;
                 if (p1_last != NULL) 
                p1_last->next = p2;
                for (;p2 != NULL; p2 = p2->next)
                {
                    if (p2->next == NULL || p2->next->val > p1->val)
                    break;
                }
               
                ListNode* tmp = p2->next;
                p2->next = p1;
                p2 = tmp; 
            }
            else
            {
                 for (;p1 != NULL; p1 = p1->next)
                {
                    if (p1->next == NULL || p1->next->val >= p2->val)
                    break;
                }
                ListNode *tmp = p1->next;
                p1->next = p2;
                p1 = p2;
                ListNode* tmp2 = p2->next;
                p2->next = tmp;
                p2 = tmp2; 
            }
            p1_last = p1;
        }

        if (p2 != NULL)
        p1_last->next = p2;
        return head;
    }
};

//递归
class Solution2 {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL) return l2;
        if (l2 == NULL) return l1;

        if (l1->val < l2->val)
        {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
        else
        {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }
        
    };
}

//迭代
class Solution3 {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode head(0);
        ListNode *p = &head;
        while (l1 != NULL && l2 != NULL)
        {
            if (l1->val < l2->val)
            {
                p->next = l1;
                l1 = l1->next;
            }
            else
            {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }
        p->next = (l1 == NULL ? l2 : l1);
        return head.next;
    };
}
