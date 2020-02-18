# -*- encoding: utf-8 -*-
# Create on 2020/2/16

class Solution:
    def toLowerCase(self, str):
        res = ""
        for ch in str:
            if 65 <= ord(ch) <= 90:
                ch = chr(ord(ch) + 32)
            res += ch
        return res

if __name__ == '__main__':
    test = Solution()
    print(test.toLowerCase("Hello"))
    print(test.toLowerCase("here"))
    print(test.toLowerCase("LOVELY"))
    print(test.toLowerCase("al&phaBET"))
