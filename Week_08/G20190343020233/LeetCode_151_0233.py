# -*- encoding: utf-8 -*-
# Create on 2020/2/18

class Solution:
    def reverseWords(self, s):
        s = s.split()
        i, j = 0, len(s) - 1
        while i < j:
            s[i], s[j] = s[j], s[i]
            i += 1
            j -= 1
        return " ".join(s)

if __name__ == '__main__':
    test = Solution()
    print(test.reverseWords("the sky is blue"))
    print(test.reverseWords("  hello world!  "))
    print(test.reverseWords("a good   example"))
