#
# @lc app=leetcode.cn id=70 lang=python3
#
# [70] 爬楼梯
#
# https://leetcode-cn.com/problems/climbing-stairs/description/
#
# algorithms
# Easy (47.25%)
# Likes:    765
# Dislikes: 0
# Total Accepted:    115.6K
# Total Submissions: 243.7K
# Testcase Example:  '2'
#
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
# 
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
# 
# 注意：给定 n 是一个正整数。
# 
# 示例 1：
# 
# 输入： 2
# 输出： 2
# 解释： 有两种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶
# 2.  2 阶
# 
# 示例 2：
# 
# 输入： 3
# 输出： 3
# 解释： 有三种方法可以爬到楼顶。
# 1.  1 阶 + 1 阶 + 1 阶
# 2.  1 阶 + 2 阶
# 3.  2 阶 + 1 阶
# 
# 
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 0:
            return 0
        if n == 1 or n == 2:
            return n
        
        # for 3
        one_step_before = 2
        two_step_before = 1
        all_steps = 0

        for i in range(3, n+1):
            # print(two_step_before, one_step_before, all_steps)
            all_steps = one_step_before + two_step_before
            two_step_before = one_step_before
            one_step_before = all_steps
        
        return all_steps

# @lc code=end

