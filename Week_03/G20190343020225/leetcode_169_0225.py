'''
@Author: your name
@Date: 2019-12-28 21:14:32
@LastEditTime : 2019-12-28 21:58:55
@LastEditors  : Please set LastEditors
@Description: In User Settings Edit
@FilePath: \leetcode\169.多数元素.py
'''
#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # 暴力法求解
        # 排序法  多数元素的比例要>1/2,因此数组最中间的数就是多数元素
        # nums.sort()
        # return nums[len(nums)//2]
        # 哈希表法
        # hash={}
        # n=len(nums)
        # if(n==1):
        #    return nums[0]
        # max_count=n//2
        # for i in range(n):
        #     if(nums[i] not in hash):
        #         hash[nums[i]]=1
        #     else:
        #         hash[nums[i]]+=1
        #         if(hash[nums[i]]>max_count):
        #             return nums[i]
    #   

        #投票法
        count = 0
        for num in nums:
            if count == 0:
                i = num
            if num == i:
                count += 1
            else:
                count -= 1
        return i



# @lc code=end

