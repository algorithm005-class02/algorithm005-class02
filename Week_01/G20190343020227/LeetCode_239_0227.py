#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:return []
        queue ,nums ,re= nums[:k] ,nums[k:] ,[]
        re.append(max(queue))
        length = len(nums)
        for i in range(0,length):
            queue.pop(0)
            queue.append(nums[i])
            re.append(max(queue))
        return re