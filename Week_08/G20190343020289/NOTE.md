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

# 字符串
1. 暴力法（brute force） - O(mn)
2. Rabin-Karp 算法
3. KMP 算法

```java
public static int forceSearch(String txt, String pat) {
	int M = txt.length();
	int N = pat.length();
	for (int i = 0; i <= M - N; i++) {
		int j;
		for (j = 0; j < N; j++) {
			if (txt.charAt(i + j) != pat.charAt(j))
			break;
		}
		if (j == N) {
			return i;
		}
		// 更加聪明？
		// 1. 预先判断– hash(txt.substring(i, M)) == hash(pat)
		// 2. KMP
	}
	return -1;
}
```