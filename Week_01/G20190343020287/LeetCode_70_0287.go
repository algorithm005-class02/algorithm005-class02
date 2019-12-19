package leetcode

// 题目地址 https://leetcode-cn.com/problems/climbing-stairs/
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
// 示例1: 输入: 2 输出: 2 解释： 有两种方法可以爬到楼顶。1.  1 阶 + 1 阶 2.  2 阶 示例2: 输入: 3 输出: 3 解释： 有三种方法可以爬到楼顶。1.  1 阶 + 1 阶 + 1 阶 2.  1 阶 + 2 阶 3.  2 阶 + 1 阶

/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

// @lc code=start
//climbStairs
//第三阶只能从第二阶和第一阶上，第三阶就是第二阶的走法+第一阶的走法
//同理第四阶只能从第三阶和第二阶上，第四阶就是第三阶的走法+第二阶的走法
func climbStairs(n int) int {
	if n < 2 {
		return n
	}
	f1, f2 := 1, 2
	for i := 2; i < n; i++ {
		f1, f2 = f2, f1+f2
	}
	return f2
}

// @lc code=end
