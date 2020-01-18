class Solution:
    # 课前尝试解题，一遍通过，但是执行时间都是 56-60ms，超过79%
    def isAnagram(self, s: str, t: str) -> bool:
        # 方法一：哈希表字母匹配
        '''
        if len(s) != len(t):
            return False
        m1 = {}
        for c in s:
            m1[c] = m1.get(c, 0) + 1
        m2 = {}
        for c in t:
            m2[c] = m2.get(c, 0) + 1
            if c not in m1 or m2[c] > m1[c]:
                return False
        return True
        '''
        # 方法二：排序
        return sorted(s) == sorted(t)

    # 课后解题
    def isAnagram(self, s: str, t: str) -> bool:
        # 参考题解方法
        if len(s) != len(t):
            return False
        dicts = {}
        for i in range(len(s)):
            dicts[s[i]] = dicts.get(s[i], 0) + 1
            dicts[t[i]] = dicts.get(t[i], 0) - 1
        for val in dicts.values():
            if val != 0:
                return False
        return True