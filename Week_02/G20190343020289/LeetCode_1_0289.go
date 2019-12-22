package G20190343020289

//1. 两数之和
func twoSum(nums []int, target int) []int {
	// 暴力法
	// a,b->a+b=target->a=target-b
	//ret := make([]int, 0)
	//for i := 0; i < len(nums); i++ {
	//	b := target - nums[i]
	//	for j := i + 1; j < len(nums); j++ {
	//		if b == nums[j] {
	//			ret = append(ret, i)
	//			ret = append(ret, j)
	//			return ret
	//		}
	//	}
	//}

	// 一次哈希
	// a,b->a+b=target->a=target-b
	// 使用Map 以val为的key,以index为map的v,空间换区时间，快速得到b
	tempMap := make(map[int]int)
	for i, v := range nums {
		b, exists := tempMap[target-v]
		if exists {
			return []int{i, b}
		}
		tempMap[v] = i
	}
	panic("no two sum")
}
