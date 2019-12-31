class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # backtrace
        phone = {
            "0": None,
            "1": None,
            "2": "abc",
            "3": "def",
            "4": "ghi",
            "5": "jkl",
            "6": "mno",
            "7": "pqrs",
            "8": "tuv",
            "9": "wxyz"
        }
        result = list()

        if not digits:
            return result
            
        self.backtrace(digits, phone, result, 0, "")
        return result

    def backtrace(self, digits, phone, result, level, target):
        if level == len(digits):
            result.append(target)
            return None

        alpha = phone[digits[level]]
        for i in alpha:
            sub_target = target + i
            self.backtrace(digits, phone, result, level+1, sub_target)
        
