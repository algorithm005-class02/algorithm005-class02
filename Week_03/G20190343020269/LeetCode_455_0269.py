class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        count = 0
        k = 0

        for i in g:
            for j in range(k, len(s)):
                if s[j] >= i:
                    count += 1
                    k = j + 1
                    break

        return count
