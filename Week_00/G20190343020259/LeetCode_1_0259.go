package G20190343020259

func twoSum(nums []int, target int) []int {
	var want = make(map[int]int)
	for k, v := range nums {
		if _, ok := want[v]; ok {
			return []int{want[v], k}
		}
		exp := target - v
		want[exp] = k
	}
	return []int{0, 0}
}
