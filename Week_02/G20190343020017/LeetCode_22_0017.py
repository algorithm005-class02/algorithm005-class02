class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        self._generate(0, 0, n, "", result)
        return result

    def _generate(self, left, right, n, s, result):
        # terminator
        if left == right and left == n:
            result.append(s)
            return
        
        # drill down
        if left < n:
            self._generate(left + 1, right, n, s + "(", result)
        if left > right:
            self._generate(left, right + 1, n, s + ")", result)