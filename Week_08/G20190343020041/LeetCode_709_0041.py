# 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
#
#
#
# 示例 1：
#
#
# 输入: "Hello"
# 输出: "hello"
#
# 示例 2：
#
#
# 输入: "here"
# 输出: "here"
#
# 示例 3：
#
#
# 输入: "LOVELY"
# 输出: "lovely"
#
# Related Topics 字符串


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def toLowerCase(self, str: str) -> str:
        return "".join([chr(ord(c) + 32) if 65 <= ord(c) <= 90 else c for c in str])


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().toLowerCase("LOVElY"))
