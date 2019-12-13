#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution:
    def mergeTwoLists(self, l1, l2):
        if l1 and l2:
            if l1.val < l2.val:
                l1.next = self.mergeTwoLists(l1.next,l2)
                return l1
            else:
                l2.next = self.mergeTwoLists(l1,l2.next)
                return l2

        return l1 or l2

