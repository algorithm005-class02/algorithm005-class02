# -*- encoding: utf-8 -*-
# Create on 2020/2/16

class Solution:
    def lengthOfLastWord_1(self, s):
        res = 0
        for ch in s.strip()[-1::-1]:
            if ch == " ":
                break
            else:
                res += 1
        return res

    def lengthOfLastWord(self, s):
        s = s.strip()
        return 0 if s == "" else len(s.split()[-1])


if __name__ == '__main__':
    test = Solution()
    print(test.lengthOfLastWord("Hello World"))
    print(test.lengthOfLastWord("a "))
    print(test.lengthOfLastWord(""))
