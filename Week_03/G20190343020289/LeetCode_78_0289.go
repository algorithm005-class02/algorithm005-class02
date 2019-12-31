package G20190343020289

//78. 子集
func subsets(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{}
	}
	ans := make([][]int, 0)
	recur(&ans, []int{}, nums, 0)
	return ans

}

func recur(ans *[][]int, temp []int, nums []int, start int) {
	*ans = append(*ans, temp)
	for i := start; i < len(nums); i++ {
		copyTemp := make([]int, len(temp))
		copy(copyTemp, temp)
		recur(ans, append(copyTemp, nums[i]), nums, i+1)
	}
}
