# 给定一个字符串，逐个翻转字符串中的每个单词。
#
#
#
# 示例 1：
#
# 输入: "the sky is blue"
# 输出: "blue is sky the"
#
#
# 示例 2：
#
# 输入: "  hello world!  "
# 输出: "world! hello"
# 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
#
#
# 示例 3：
#
# 输入: "a good   example"
# 输出: "example good a"
# 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
#
#
#
#
# 说明：
#
#
# 无空格字符构成一个单词。
# 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
# 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
#
#
#
#
# 进阶：
#
# 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
# Related Topics 字符串


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseWords(self, s: str) -> str:
        s = list(s[::-1])
        print(s)
        n = len(s)

        self.reverse_word(n, s)
        s = self.clean_space(n, s)
        return "".join(s)

    def clean_space(self, n, s):
        i, j = 0, 0
        while j < n:
            while j < n and s[j] == ' ': j += 1
            while j < n and s[j] != ' ': s[i] = s[j]; i += 1;j += 1
            while j < n and s[j] == ' ': j += 1
            if j < n: s[i] = " "; i += 1
        return s[:i]

    def reverse_word(self, n, s):
        i, j = 0, 0
        while i < n:
            while i < j or i < n and s[i] == ' ': i += 1
            while j < i or j < n and s[j] != ' ': j += 1
            s[i:j] = reversed(s[i:j])


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().reverseWords("a good   example"))
