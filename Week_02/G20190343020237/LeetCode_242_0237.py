#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
# https://leetcode-cn.com/problems/valid-anagram/description/
#
# algorithms
# Easy (57.21%)
# Likes:    135
# Dislikes: 0
# Total Accepted:    62.7K
# Total Submissions: 109.3K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
#
#
# 示例 2:
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 说明:
# 你可以假设字符串只包含小写字母。
#
# 进阶:
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
#
#

# @lc code=start


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        # # 2019-12-19 22:07:43
        # # O(max(len(s),len(t))); O(n)
        # # 通过char2count比较
        # char2count = {}

        # if len(s) != len(t):    # O(n), 没有必要
        #     return False

        # for c in s:
        #     if c in char2count: char2count[c] += 1
        #     else: char2count[c] = 1

        # for c in t:
        #     if c not in char2count or char2count[c] == 0: return False
        #     char2count[c] -= 1

        # for c, n in char2count.items():
        #     if n != 0: return False

        # return True

        # O(n), O(n)
        c2freq = {}
        for c in s: c2freq[c] = c2freq.get(c, 0) + 1
        for c in t: c2freq[c] = c2freq.get(c, 0) - 1
        for k, v in c2freq.items():
            if v != 0:
                return False
        return True


# @lc code=end
