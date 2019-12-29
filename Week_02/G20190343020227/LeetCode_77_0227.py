#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    #库函数 48ms
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        from itertools import combinations
        return list(combinations(range(1, n+1), k))

    #回溯算法 504ms
    def combine2(self, n, k):
        res = []
        self.lever = 0
        def backtrack(i,k,tmp):
            if k == 0:
                res.append(tmp)
                return
            for j in range(i,n+1):
                backtrack(j+1,k-1,tmp+[j])
        backtrack(1,k,[])
        return res