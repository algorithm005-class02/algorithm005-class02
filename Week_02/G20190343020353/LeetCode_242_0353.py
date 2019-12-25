"""
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


class Solution(object):
    def isAnagram1(self, s, t):
        """
        暴力法：先排序，再比较
        """
        return sorted(s) == sorted(t)

    def isAnagram2(self, s, t):
        """使用Python内置的计数器进行统计字符串中每个字母出现的次数并比较"""
        from collections import Counter
        return Counter(s) == Counter(t)

    def isAnagram3(self, s, t):
        from collections import defaultdict
        d = defaultdict(int)
        for i in s:
            d[i] += 1

        for i in t:
            d[i] -= 1
            if not d[i]:
                del d[i]
        return not d
