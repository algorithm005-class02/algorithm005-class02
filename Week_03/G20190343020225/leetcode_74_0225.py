'''
@Author: your name
@Date: 2019-12-27 11:08:05
@LastEditTime : 2019-12-27 17:49:19
@LastEditors  : Please set LastEditors
@Description: In User Settings Edit
@FilePath: \leetcode\74.搜索二维矩阵.py
'''
#
# @lc app=leetcode.cn id=74 lang=python3
#
# [74] 搜索二维矩阵
#

# @lc code=start
class Solution:
    def searchMatrix(self, matrix, target):
        if not matrix or target is None:
            return False

        rows, cols = len(matrix), len(matrix[0])
        low, high = 0, rows * cols - 1        
        while low <= high:
            mid = (low + high) // 2
            num = matrix[mid // cols][mid % cols] # 关键点

            if num == target:
                return True
            elif num < target:
                low = mid + 1
            else:
                high = mid - 1       
        return False
       
# @lc code=end

