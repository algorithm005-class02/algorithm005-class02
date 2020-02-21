class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s)!=len(t):
            return False
        slen,sdata,tdata = len(s) ,{} , {}
        for i in range(0,slen):
            if s[i] not in sdata:
                sdata[s[i]] = t[i]
            else:
                if sdata[s[i]] != t[i]:
                    return False
            if t[i] not in tdata:
                tdata[t[i]] = s[i]
            else:
                if tdata[t[i]] != s[i]:
                    return False
        return True