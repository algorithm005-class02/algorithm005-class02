'''
@Author: your name
@Date: 2019-12-23 13:55:52
@LastEditTime : 2019-12-23 14:02:52
@LastEditors  : Please set LastEditors
@Description: In User Settings Edit
@FilePath: \leetcode\69.x-的平方根.py
'''
#
# @lc app=leetcode.cn id=69 lang=python3
#
# [69] x 的平方根
#

# @lc code=start
class Solution:
    def mySqrt(self, x: int) -> int:
        l,r = 0,x
        
        while l <= r:
            mid = (r-l) // 2+l
            if mid * mid <= x < (mid+1)*(mid+1):
                return mid
            elif x < mid * mid:
                r = mid
            else:
                l = mid + 1
        return mid



        
# @lc code=end

