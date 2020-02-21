package G20190343020289

func majorityElement(nums []int) int {
	// map
	median := len(nums) / 2
	maps := make(map[int]int)
	for _, val := range nums {
		if maps[val]+1 > median {
			return val
		}
		maps[val]++
	}
	return 0
}

//func majorityElement(nums []int) int {
//	// 投票法
//	cur := nums[0]
//	count := 1
//	for i, v := range nums {
//		if v == cur {
//			count++
//		} else {
//			count--
//		}
//		if count == 0 {
//			cur = nums[i]
//			count = 1
//		}
//	}
//	return cur
//}

//func majorityElement(nums []int) int {
//	// 排序
//	sort.Ints(nums)
//	return nums[len(nums)/2]
//}
