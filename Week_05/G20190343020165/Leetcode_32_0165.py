class Solution:
    def longestValidParentheses(self, s: str) -> int:
        #找规律
        #dp[0]-dp[i]的值 代表当前第i个字符串，最长的长度是多少
        #当第i个数等于(时，代表dp[i]=0。所以需要循环遍历s,当s[i]=)时，进行判断
        #当s[i]=)时，若s[i-1]=(,说明两个括号匹配。dp[i] = dp[i-2] + 2。这个式子的意思是因为dp[i-2]的长度已经计算完成了，所以用i-1前面的长度加上2的长度就是dp[i]的长度
        #当s[i-1]=)时，说明前面可能有匹配的括号，需要判断i - dp[i-1] -1 这个位置的字符串是否是（。这里的i-dp[i-1]-1指的是找到最上层还没匹配的位置
        #找到位置后，符合条件的时候 dp[i] = dp[i-1] + dp[i - dp[i-1] -2 ]+2
        if not s:
            return 0
        res = 0
        count = len(s)
        dp = [0]*count
        for i in range(1,count):
            if(s[i] == ')'):
                if(s[i-1] == '('):
                    dp[i] = dp[i-2] + 2
                if(s[i-1] == ')' and i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1]=='('):
                    dp[i] = dp[i-1] + dp[i-dp[i-1]-2] +2
                res = max(res, dp[i])
        return res