#
# @lc app=leetcode.cn id=387 lang=python3
#
# [387] 字符串中的第一个唯一字符
#

# @lc code=start
class Solution:
    def firstUniqChar(self, s: str) -> int:
        # hash   58% 44%
        cnt = {}
        for c in s:
            if c in cnt:
                cnt[c] += 1
            else:
                cnt[c] = 1
        for i, c in enumerate(s):
            if cnt[c] == 1:
                return i
        return -1
        
# @lc code=end

