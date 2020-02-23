class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not s:
            return 0
        cur_max = 0
        longest = [0 for _ in range(len(s))]
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    longest[i] = longest[i-2]+2 if i-2 > 0 else 2
                    cur_max = max(longest[i], cur_max)
                elif i - longest[i-1] - 1 >= 0 and s[i-longest[i-1]-1] == '(':
                    longest[i] = longest[i-1]+2 + (longest[i-longest[i-1]-2] if i-longest[i-1]-2>0 else 0)
                    cur_max = max(longest[i], cur_max)
        return cur_max
                    