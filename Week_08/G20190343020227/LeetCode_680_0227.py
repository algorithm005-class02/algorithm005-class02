class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == s[::-1]:
            return True
        i , j= 0 , len(s)-1

        while i < j:
            if s[i] != s[j]:
                a = s[:i] + s[i+1:]
                if a == a[::-1]:
                    return True
                b = s[:j] + s[j+1:]
                if b == b[::-1]:
                    return True
                return False
            else:
                 i , j = i+1 ,j -1
        return False