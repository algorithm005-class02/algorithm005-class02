class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res=''
        tmp=0
        while tmp+2*k<len(s):
            res=res+s[tmp:tmp+k][::-1]
            res=res+s[tmp+k:tmp+2*k]
            tmp+=2*k
        if tmp+k<len(s):
            res=res+s[tmp:tmp+k][::-1]
            res=res+s[tmp+k:]
        else:
            res=res+s[tmp:][::-1]
        return res