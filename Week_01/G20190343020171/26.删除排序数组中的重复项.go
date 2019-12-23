package G20190343020171
/*
 * @lc app=leetcode.cn id=26 lang=golang
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
func removeDuplicates(nums []int) int {
	// 初始求解；疑问：输入[1,1,2] leetcode执行输出[1,1] 代码错在哪儿呢？
	/*** 
	var (
		numLen = len(nums)
		thumb = nums[0]
	)
	for idx := 1; idx < len(nums); idx ++ {
		if nums[idx] == thumb {
			numLen --
		} 
		thumb = nums[idx]
	}
	return numLen 
	***/

	// 快慢指针求解
	var (
		idxi = 0
	)
	for idxj := 1; idxj < len(nums); idxj ++ {
		if nums[idxi] != nums[idxj] {
			idxi ++
			nums[idxi] = nums[idxj]
		}
	}

	return idxi + 1
}
// @lc code=end