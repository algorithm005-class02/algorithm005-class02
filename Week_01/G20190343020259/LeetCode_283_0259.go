package G20190343020259

func moveZeroes(nums []int)  {
	c := len(nums)
	j := 0
	for i := 0; i < c; i++ {
		if nums[i] != 0 {
			tmp := nums[j]
			nums[j] = nums[i]
			nums[i] = tmp
			j++
		}
	}
}
