class Solution:
    # 回溯递归
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        num2letter = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        result = []
        def helper(string, chars):
            # terminator
            if not string:
                result.append(chars)
                return

            # process & drill down
            for char in num2letter[string[0]]:
                helper(string[1:], chars + char)
        helper(digits, "")
        return result

    # 迭代法
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        num2letter = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        result = [""]
        for num in digits:
            result = [item + letter for letter in num2letter[num] for item in result]
        return result