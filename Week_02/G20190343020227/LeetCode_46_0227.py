#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    #解法1，回溯算法
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res,n = [],len(nums)
        if nums is None:
            return res
        def findCombination(first):
            if first == n:
                res.append(nums[:])
            for i in range(first,n):
                nums[i],nums[first] = nums[first],nums[i]
                findCombination(first + 1)
                nums[i],nums[first] = nums[first],nums[i]
        findCombination(0)
        return res

    #解法2,国际站光头哥的解法，看不太懂但是太秀了。。
    def permute2(self, nums):
        return reduce(lambda P, n: [p[:i] + [n] + p[i:]
                                for p in P for i in range(len(p)+1)],
                  nums, [[]])