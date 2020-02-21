#1.暴力
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): 
            return False
        else: 
            return(sorted(s) == sorted(t))
#2.hash
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        else:
            dicts = collections.defaultdict(int)
            for i in range(len(s)):
                dicts[s[i]] += 1
                dicts[t[i]] -= 1
            for val in dicts.values():
                if val != 0:
                    return False
            return True