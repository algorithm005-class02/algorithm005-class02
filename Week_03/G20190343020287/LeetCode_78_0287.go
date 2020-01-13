package leetcode

/*
 * @lc app=leetcode.cn id=78 lang=golang
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.70%)
 * Likes:    419
 * Dislikes: 0
 * Total Accepted:    50.8K
 * Total Submissions: 67.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠[3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */

// @lc code=start
// [[] [1]]
// [[] [1] [2] [2 1]]
// [[] [1] [2] [2 1] [3] [3 1] [3 2] [3 2 1]]
func subsets1(nums []int) [][]int {
	ret := [][]int{{}}

	for _, n := range nums {
		newsets := [][]int{}
		for _, r := range ret {
			newsets = append(newsets, append([]int{n}, r...))
			// newsets = append(newsets, append(r, n)) 会报错
		}
		ret = append(ret, newsets...)
	}
	return ret
}

// subsets2 利用回溯
// nums 输入数组，ret 是结果，i 是当前层，tmp 当前层产生的数据，n nums 长度
// []
// [[]]
// [[] [1]]
// [[] [1] [2 1]]
// [[] [1] [2 1] [3 2 1]]
// [[] [1] [2 1] [3 2 1] [3 1]]
// [[] [1] [2 1] [3 2 1] [3 1] [2]]
// [[] [1] [2 1] [3 2 1] [3 1] [2] [3 2]]
func subsets2(nums []int) [][]int {
	ret := [][]int{}

	recall(nums, &ret, 0, []int{}, len(nums))

	return ret
}

func recall(nums []int, ret *[][]int, i int, tmp []int, n int) {
	*ret = append(*ret, tmp)
	for j := i; j < n; j++ {
		recall(nums, ret, j+1, append([]int{nums[j]}, tmp...), n)
	}
}

// @lc code=end
