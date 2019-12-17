"""
思路：
利用栈，遇到左边入栈，遇到右边出栈，如果不匹配则无效，遍历完，如果栈为空，则为有效的括号
时间 O(n) 空间 O(n)
"""

#28ms 12.8mb
class Solution:
    def isValid(self, s: str) -> bool:
        parentheses = {']':'[', ')': '(', '}':'{'}
        stack = []
        for c in s:
            if c in parentheses.values():
                stack.append(c)
            elif c in parentheses:
                if not stack or stack[-1] != parentheses[c]:
                    return False
                stack.pop()
        return len(stack) == 0