#!/usr/bin/python
# -*- coding: UTF-8 -*-
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 3:return n
        arr = [0 for x in range(0,n+1)]
        arr[1],arr[2],index = 1,2,3
        while(index <= n):
            arr[index] = arr[index-1] + arr[index-2]
            index += 1
        return arr[n]