class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        data = {}
        for i in s:
            if i not in data:
                data[i] = 0
            else:
                data[i] = data[i] + 1
        for index,ch in enumerate(s):
            if data[ch] == 0:
                return index
        return -1