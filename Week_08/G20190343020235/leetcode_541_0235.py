class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        length = len(s)
        s = list(s)
        for i in range(0, length, 2*k):
            start = i
            end = i + k - 1 if i + k - 1 < length else length - 1
            while start <= end:
                s[start], s[end] = s[end], s[start]
                start += 1
                end -= 1
        return ''.join(s)
        