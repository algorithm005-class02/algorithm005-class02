class Solution:
    def generateParenthesis(self, n):
        result = []
        self.generate_parenthesis(n, n, "", result)
        return result

    def generate_parenthesis(self, left, right, s, result):
        if right == 0:
            result.append(s)
            return result
        if left > 0:
            self.generate_parenthesis(left - 1, right, s + "(", result)
        if right > left:
            self.generate_parenthesis(left, right - 1, s + ")", result)

    def generateParenthesis_bfs(self, n):
        process = [["(", n-1, n]]
        results = []
        while process:
            current, left, right = process.pop(0)
            if len(current) == n * 2:
                results.append(current)
            if left > 0:
                process.append([current + "(", left - 1, right])
            if right > left:
                process.append([current + ")", left, right - 1])
        return results

if __name__ == '__main__':
    test = Solution()
    print(test.generateParenthesis_bfs(3))

