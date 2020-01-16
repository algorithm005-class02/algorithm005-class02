package leetcode

// 题目地址 https://leetcode-cn.com/problems/container-with-most-water/
// 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
// 示例: 输入: [1,8,6,2,5,4,8,3,7] 输出: 49
// 说明：你不能倾斜容器，且 n 的值至少为 2。

/*
 * @lc app=leetcode.cn id=11 lang=golang
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
// maxArea1
// 利用两层循环，枚举所有肯能值，取最大值
func maxArea1(height []int) int {
	maxArea := 0
	for i := 0; i < len(height)-1; i++ {
		for j := i + 1; j < len(height); j++ {
			width := j - i
			high := height[j]
			if height[i] < height[j] {
				high = height[i]
			}
			if maxArea < width*high {
				maxArea = width * high
			}
		}
	}
	return maxArea
}

// maxArea2
// 利用一层循环，向中间移动，直到相遇
func maxArea(height []int) int {
	maxArea, i, j := 0, 0, len(height)-1
	for i < j {
		width := j - i
		high := 0
		if height[i] < height[j] {
			high = height[i]
			i++
		} else {
			high = height[j]
			j--
		}
		if maxArea < width*high {
			maxArea = width * high
		}
	}
	return maxArea
}

// @lc code=end
