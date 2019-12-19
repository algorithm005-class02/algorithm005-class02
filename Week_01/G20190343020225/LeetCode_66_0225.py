#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#总结:主要分为两种情况:
# 末尾有9和没有9,没有9的话直接在末尾加1即可,末尾有9,将末尾数向前
# 进一位,末尾数字变成0,例如[9,9]会变为[0,0],最后再进行判断
# 如果首位数字为0,将首位数字赋值为1,在末尾增加一个0即可


# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        len_ = len(digits)-1
        for i in range(len_,-1,-1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                break
        if digits[0] == 0:
            digits[0] = 1
            digits.append(0)
        return digits
# @lc code=end

