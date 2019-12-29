#!/usr/bin/python
# -*- coding: UTF-8 -*-
#哈希表法
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i, m in enumerate(nums):
            d[m] = i
        for i, m in enumerate(nums):
            j = d.get(target - m)
            if j is not None and i != j:
                return [i,j]
        return []