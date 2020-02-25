# 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
#
#
#
#
#
#
# 示例 1：
#
# 输入："ab-cd"
# 输出："dc-ba"
#
#
# 示例 2：
#
# 输入："a-bC-dEf-ghIj"
# 输出："j-Ih-gfE-dCba"
#
#
# 示例 3：
#
# 输入："Test1ng-Leet=code-Q!"
# 输出："Qedo1ct-eeLg=ntse-T!"
#
#
#
#
# 提示：
#
#
# S.length <= 100
# 33 <= S[i].ASCIIcode <= 122
# S 中不包含 \ or "
#
# Related Topics 字符串


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        i, j = 0, len(s) - 1
        s = list(s)
        while i < j:
            while i < j and s[i].isalpha() and s[j].isalpha():
                s[i], s[j] = s[j], s[i]
                i += 1
                j -= 1
            while i < j and not s[i].isalpha():
                i += 1
            while i < j and not s[j].isalpha():
                j -= 1
        return "".join(s)


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().reverseOnlyLetters("a-bC-dEf-ghIj"))
