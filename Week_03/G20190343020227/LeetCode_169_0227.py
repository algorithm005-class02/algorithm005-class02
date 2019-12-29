#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    #分治法
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:return None #边界
        if len(nums)==1:return nums[0] #边界
        a = self.majorityElement(nums[:len(nums)//2]) #处理左边
        b = self.majorityElement(nums[len(nums)//2:]) #处理右边
        if a == b:return a #相同，取a
        return [b,a][nums.count(a)>len(nums)//2] #如果后面的表达式为真，返回a，否则返回b

    #利用python的set
    def majorityElement2(self, nums):
        if not nums:return None #边界
        if len(nums)==1:return nums[0] #边界
        little_nums = set(nums) #去除重复元素
        for num in little_nums:
            if nums.count(num)>len(nums)//2:
                return num
        return nums[0]