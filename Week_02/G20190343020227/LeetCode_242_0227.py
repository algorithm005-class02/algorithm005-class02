#一个非常偷懒的方法。。 48s
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return sorted(s) == sorted(t)


#哈希表法 24s
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        d = {}
        for i in s:
            if i in d:
                d[i] = d[i] + 1
            else:
                d[i] = 1
        for i in t:
            if i not in d:
                return False
            else:
                d[i] = d[i] - 1
        for i in d:
            if d[i] != 0:
                return False
        return True