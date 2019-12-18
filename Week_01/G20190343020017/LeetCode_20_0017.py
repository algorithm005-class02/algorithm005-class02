class Solution:
    def isValid(self, s: str) -> bool:
        maps, stack = {"(": ")", "[": "]", "{": "}"}, []
        for c in s:
            if c in maps:
                stack.append(c)
            elif not stack or maps[stack.pop()] != c:
                return False
        return not stack