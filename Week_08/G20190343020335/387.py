class Solution:
    def firstUniqChar(self, s: str) -> int:
        sta = {}
        for i in range(len(s)):
            sta[s[i]] = sta.get(s[i],0) + 1
        for i in range(len(s)):
            if sta[s[i]] == 1:
                return i
        return -1
        
