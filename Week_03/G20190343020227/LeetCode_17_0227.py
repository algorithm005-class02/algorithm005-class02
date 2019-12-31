class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        res,phone =[], {"2":['a','b','c'],
                        "3":['d','e','f'],
                        "4":['g','h','i'],
                        "5":['j','k','l'],
                        "6":['m','n','o'],
                        "7":['p','q','r','s'],
                        "8":['t','u','v'],
                        "9":['w','x','y','z']}

        def backtrack(com,next_digit):
            if len(next_digit)==0:#递归出口
                res.append(com)
            else:
                for letter in phone[next_digit[0]]:
                    backtrack(com+letter,next_digit[1:]) #回溯点
        
        if digits:   
            backtrack('',digits)
        return res