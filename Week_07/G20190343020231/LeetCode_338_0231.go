package G20190343020231

func countBits(num int) []int {
	if num == 0 {
		return []int{0}
	}
	count := make([]int, num + 1)
	count[0] = 0
	for i := 1; i <= num; i++ {
		count[i] = count[i & (i - 1)] + 1
	}
	return count
}