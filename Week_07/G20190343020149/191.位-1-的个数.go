package leetcode

/*
 * @lc app=leetcode.cn id=191 lang=golang
 *
 * [191] 位1的个数
 */

// @lc code=start
func hammingWeight(num uint32) int {
	ret := 0
	for num != 0 {
		num = num & (num - 1)
		ret++
	}
	return ret
}

// @lc code=end
