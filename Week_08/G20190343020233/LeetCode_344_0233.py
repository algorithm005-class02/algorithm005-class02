# -*- encoding: utf-8 -*-
# Create on 2020/2/18

class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        需要达到滚瓜烂熟的程度
        """
        i, j = 0, len(s) - 1
        while i < j:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
        print(s)

if __name__ == '__main__':
    test = Solution()
    test.reverseString(["h","e","l","l","o"])
