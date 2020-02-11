学习笔记

# 动态规划

[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)
```
E 5 4 4 3
S 4 3 3 2
R 3 2 2 2
O 2 2 1 2
H 1 1 2 3
# 0 1 2 3 
  # R O S
```

边界为
```
dp[0][j]=j
dp[i][0]=i
```
1. word1[i]=word2[i]的情况下
```
dp[i][j]=dp[i-1][j-1]
```
2. word1[i]!=word2[i]的情况下
```
insert  dp[i][j]=dp[i-1][j]+1
replace dp[i][j]=dp[i-1][j-1]+1
delete  dp[i][j]=dp[i][j-1]+1
去三者中最小的情况
dp[i][j] = 1+min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])
```
