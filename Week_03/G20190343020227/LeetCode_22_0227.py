class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        res = []
        def backtrack(s,l,r):
            if len(s) == 2*n: #递归出口，长度为2n时进栈
               return res.append(s)
            if l < n:
                backtrack(s+"(",l+1,r) #回溯点，左边一起画个龙
            if r < l:
                backtrack(s+")",l,r+1) #回溯点，右边再画道彩虹
        backtrack("",0,0)
        return res