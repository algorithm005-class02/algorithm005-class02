#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
# 五毒神掌：第二遍

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
# 方法一，暴力破解，超过时间限制，解题思路是你告诉我要移动多少次，然后每次我都会
# 让每位队员向前一步，而最后那位队员则往回走站在第一位（循环），这样整个队伍整体
# 移动K次后，就是每个队员往前走K步的结果
        # tmp = 0
        # for i in range(k):
        #     previous = nums[-1]
        #     for j in range(len(nums)):
        #         tmp = nums[j]
        #         nums[j] = previous
        #         previous = tmp

# 方法二，环形解法，解题思路是不需每次都移动全部队员，我们让第一位队员直接往前K步
# 而第K位队员则要让出位置，然后也往前走K步（遇到队尾则循环），以此类推，直到某位队员
# 回到第一位置上。当队伍成员数和移动次数均为偶数时，即移动次数能被成员数整除，则一次
# 完成，否则需要第二位成员开始新一轮循环，直到有人又回到第一位置上。
        k = k % len(nums)
        count = 0
        for start in range(len(nums)):
            current = start
            previous = nums[start]
            while True:
                next_num = (current + k) % len(nums)
                tmp = nums[next_num]
                nums[next_num] = previous
                previous = tmp
                current = next_num
                count += 1
                if current == start:
                    break
            if count >= len(nums):
                break
        
#rotate([1,2,3],2)

# @lc code=end
        

