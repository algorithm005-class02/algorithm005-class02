#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if not height:return 0
        res,left,right = 0,0,len(height)-1
        left_max ,right_max = height[left] ,height[right]
        while left < right:
            if height[left] < height [right]:
                if left_max > height[left]:
                    res += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
            else:
                if right_max > height[right]:
                    res += right_max - height[right]
                else:
                    right_max = height[right]
                right -= 1 
        return res


