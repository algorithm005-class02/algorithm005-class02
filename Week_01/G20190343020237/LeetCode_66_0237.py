#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#
# https://leetcode-cn.com/problems/plus-one/description/
#
# algorithms
# Easy (41.97%)
# Likes:    384
# Dislikes: 0
# Total Accepted:    100.1K
# Total Submissions: 237.9K
# Testcase Example:  '[1,2,3]'
#
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
#
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
#
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
#
# 示例 1:
#
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
#
#
# 示例 2:
#
# 输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
#
#
#

# @lc code=start


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:

        # T: O(log(digits)), S: T(1)
        # 109/109 cases passed (36 ms)
        # Your runtime beats 93.45 % of python3 submissions
        # Your memory usage beats 99.64 % of python3 submissions (12.8 MB)

        for i in range(len(digits)-1, -1, -1):
            tmp = digits[i] + 1
            digits[i] = tmp % 10
            carry_out = tmp // 10
            if carry_out == 0:
                break

        if carry_out > 0:
            digits = [carry_out] + digits[:]

        return digits

    # @lc code=end
