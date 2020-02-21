class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        l =  s.split(" ")
        for i,v in enumerate(l):
            l[i] = v[::-1]
        return " ".join(l)
        


