package leetcode

/*
 * @lc app=leetcode.cn id=46 lang=golang
 *
 * [46] 全排列
 */

// @lc code=start
func permute(nums []int) [][]int {
	numLen := len(nums)
	if numLen == 0 {
		return [][]int{}
	} else if numLen == 1 {
		return [][]int{[]int{nums[0]}}
	}
	baseNum := nums[0]
	result := [][]int{}
	otherNums := nums[1:]
	middleCombines := permute(otherNums)

	for _, mc := range middleCombines {
		// 头部插入
		result = append(result, append([]int{baseNum}, mc...))
		// 尾部插入
		result = append(result, append(mc, baseNum))
		// 中间插入
		for i := 1; i < len(mc); i++ {
			//
			leftSide := append([]int{}, mc[0:i]...)
			rightSide := append([]int{baseNum}, mc[i:]...)
			temp := append(leftSide, rightSide...)
			result = append(result, temp)
		}
	}
	return result
}

// @lc code=end
