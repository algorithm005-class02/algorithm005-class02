class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import Counter
        pattern = Counter(t)
        formed = 0
        slow = 0
        res = ""

        for fast, c in enumerate(s):
            if c not in pattern:
                continue
            pattern[c] -= 1
            if pattern[c] == 0:
                formed += 1

            while formed == len(pattern) and slow <= fast:
                if not res or len(res) > fast-slow+1:
                    res = s[slow:fast+1]
                ch = s[slow]
                if ch in pattern:
                    pattern[ch] += 1
                if pattern[ch] == 1:
                    formed -= 1
                slow += 1
        return res
