class Solution:
    def letterCombinations(self, digits):
        mapping = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', 
                   '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return list(mapping[digits[0]]) 
        prev = self.letterCombinations(digits[:-1]) 
        additional = mapping[digits[-1]] 
        return [s + c for s in prev for c in additional]