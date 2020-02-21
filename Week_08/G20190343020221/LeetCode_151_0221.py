class Solution:
    def reverseWords(self, s: str) -> str:
        s1=s.split()
        s1.reverse()
        return " ".join(s1)
