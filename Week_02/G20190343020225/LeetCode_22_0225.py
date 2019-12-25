class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        def _generate(left=0, right=0, s=''):
            if left == n and right == n:
                res.append(s)
                return
            if left < n:
                _generate(left+1, right, s + "(")
            if left > right:
                _generate(left, right+1, s+ ")")
        _generate()
        return res

    # def generateParenthesis(self, N):
    #     ans = []
    #     def backtrack(S = '', left = 0, right = 0):
    #         if len(S) == 2 * N:
    #             ans.append(S)
    #             return
    #         if left < N:
    #             backtrack(S+'(', left+1, right)
    #         if right < left:
    #             backtrack(S+')', left, right+1)

    #     backtrack()
    #     return ans