# 第八周总结
所有的学习最重要的部分都是一定要花时间去练习，正如老师第一周课程及后面反复给我们讲到的五毒神掌，刻意练习，题目只做一遍的误区，后面还是需要反复学习练习，随着课程到了尾声，发现很多题目反复出现在不同的解法上，只有把基础打牢了才可以在各个问题上都游刃有余，找到重复性。
## 19.高级动态规划
- 动态规划复习;附带 递归、分治
- 多种情况的动态规划的状态转移方程串讲
- 进阶版动态规划的习题
### 关键点
- 动态规划 和 递归或者分治 没有根本上的区别(关键看有无最优的子结构)
- 拥有共性:找到重复子问题
- 差异性:最优子结构、中途可以淘汰次优解
####  高阶的 DP 问题 - 复杂度来源
- 1. 状态拥有更多维度(二维、三维、或者更多、甚至需要压缩)
- 2. 状态方程更加复杂
- 本质:内功、逻辑思维、数学

## 20.字符串
###  字符串相关算法
- 1. 暴力递归
- 2. 动态规划
    dp[i][j] 代表 T 前 i 字符串可以由 s 前 j 字符串组成最多个数。 所以动态方程:
    当 S[j] == T[i], dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
    当 S[j] != T[i], dp[i][j] = dp[i][j-1]
###  字符串匹配算法
- 1. 暴力法(brute force) - O(mn)
- 2. Rabin-Karp 算法
- 3. KMP 算法