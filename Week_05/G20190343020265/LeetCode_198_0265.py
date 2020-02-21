#
# @lc app=leetcode.cn id=198 lang=python3
#
# [198] 打家劫舍
# 解题思路，有n家,f()为该家的存款
# 当n=0，返回0
# 当n=1，返回f(i)
# 当n=2，返回max(f(i),f(i-1))
# 当n>=3，返回max(f(i)+f(i-2),f(i-1))，选当前这个和隔一个，或者选紧邻那个
# 于是用递推公式得到结果

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
        cur = 0
        pre = 0
        for i in nums:
            temp = cur
            cur = max(pre + i, cur)
            pre = temp
        return cur
        
# @lc code=end

