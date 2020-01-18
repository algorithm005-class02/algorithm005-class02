package leetcode

/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 */

// @lc code=start
func combine(n int, k int) [][]int {
	return combineStep(1, n, k)
}

func combineStep(startN int, n int, k int) [][]int {
	if k < 1 {
		return [][]int{}
	}
	result := [][]int{}
	for i := startN; i < n-k+2; i++ {
		// 获取子组合值
		middleResults := combineStep(i+1, n, k-1)
		if len(middleResults) > 0 {
			for _, middleArr := range middleResults {
				middleArr = append(middleArr, i)
				result = append(result, middleArr)
			}
		} else {
			result = append(result, []int{i})
		}

	}
	return result
}

// @lc code=end
