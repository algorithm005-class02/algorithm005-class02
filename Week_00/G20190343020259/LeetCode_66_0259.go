package G20190343020259

func plusOne(digits []int) []int {
	count := len(digits)

	for i := count - 1; i >= 0; i-- {
		digits[i]++
		digits[i] = digits[i] % 10
		if digits[i] != 0 {
			return digits
		}
	}
	digits = make([]int, count+1)
	digits[0] = 1

	return digits
}
