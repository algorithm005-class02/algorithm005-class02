package G20190343020289

//189. 旋转数组
func rotate(nums []int, k int) {
	//	暴力法
	//temp := 0
	//pre := 0
	//length := len(nums)
	//for i := 0; i < k; i++ {
	//	pre = nums[length-1]
	//	for j := 0; j < length; j++ {
	//		temp = nums[j]
	//		nums[j] = pre
	//		pre = temp
	//	}
	//}

	m := k% len(nums)
	reverse(nums, 0, len(nums)-1)
	reverse(nums, 0, m-1)
	reverse(nums, k, len(nums)-1)
}

func reverse(nums []int, start int, end int) {
	for {
		temp := nums[start]
		nums[start] = nums[end]
		nums[end] = temp
		start++
		end--
		if start >= end {
			break
		}
	}
}
