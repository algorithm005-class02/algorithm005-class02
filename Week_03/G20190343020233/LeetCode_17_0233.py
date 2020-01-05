class Solution:
    def letterCombinations(self, digits):
        nums_letters = {
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return list(nums_letters[digits])
        return [x + y for x in self.letterCombinations(digits[0]) for y in self.letterCombinations(digits[1:])]


if __name__ == '__main__':
    test = Solution()
    print(test.letterCombinations("23"))
