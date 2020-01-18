#
# @lc app=leetcode.cn id=860 lang=python3
#
# [860] 柠檬水找零
#

# @lc code=start
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # 贪心   97%  100%
        five, ten = 0, 0
        for i in bills:
            if i == 5:
                five += 1
            elif i == 10:
                ten += 1
                five -= 1
            elif ten > 0:
                five -= 1
                ten -= 1
            else:
                five -= 3
            if five < 0:
                return False
        return True
        
# @lc code=end

