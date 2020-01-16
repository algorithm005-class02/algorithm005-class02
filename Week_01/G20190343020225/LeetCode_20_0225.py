#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start
class Solution:
     # 暴力法求解
     # def isValid(self, s):
     #    while '{}' in s or '()' in s or '[]' in s:
     #        s = s.replace('{}', '')
     #        s = s.replace('[]', '')
     #        s = s.replace('()', '')
     #    return s == ''
     
    # def isValid(self, s: str) -> bool:
    #     li = []
    #     for i in s:
    #         if i == '(' or i == '[' or i == '{':
    #             li.append(i)
    #         if i == ')' or i == ']' or i == '}':
    #             if li == []:
    #                 return False
    #             elif abs(ord(i) - ord(li.pop(-1))) > 2: 转化为二进制进行处理
    #                 return False
    #     return li == []
   
        # map = {'(':')','{':'}','[':']'}
        
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i =='(':
                stack.append(')')               
            elif i == '{':
                stack.append('}')                
            elif i == '[':
                stack.append(']')  
            elif stack == [] or i != stack.pop():
                return False             
        if stack ==[]:
            return True

        return False
        
# @lc code=end

