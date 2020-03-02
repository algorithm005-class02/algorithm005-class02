class Solution:
    def firstUniqChar(self, s: str) -> int:
        repeated_chars = set()
        for i in range(len(s)): 
            if s[i] not in repeated_chars and s[i] not in s[i+1:]:
                return i
            else:
                repeated_chars.add(s[i])
        return -1