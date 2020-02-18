class Solution(object):
    def numDecodings(self, s):
 
        if s == "" or s[0] == "0":  #如09这种
            return 0
        if len(s) == 1:
            return 1
			
        dp = [1,1]
        for i in range(2, len(s)+1):

            if 10 <= int(s[i-2:i]) <= 26 and s[i-1] != '0': 
                dp.append(dp[i-1]+dp[i-2])
            elif int(s[i-2:i]) == 10 or int(s[i-2:i]) == 20:
                dp.append(dp[i-2])  
            elif s[i-1]!='0':       
                dp.append(dp[i-1])  
            else:
                return 0   
        return dp[-1]