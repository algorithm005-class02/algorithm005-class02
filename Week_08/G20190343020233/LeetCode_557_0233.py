# -*- encoding: utf-8 -*-
# Create on 2020/2/18

class Solution:
    def reverseWords(self, s):
        return " ".join(x[::-1] for x in s.split())

if __name__ == '__main__':
    test = Solution()
    print(test.reverseWords("Let's take LeetCode contest"))

