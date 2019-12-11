package main

func main() {
	test := []int{0, 0, 0, 1, 1, 1}
	test2 := []int{0, 1, 0, 2, 4, 0}
	moveZeroes(test)
	moveZeroes(test2)
	moveZeroes2(test)
	moveZeroes2(test2)
	moveZeroes3(test)
	moveZeroes3(test2)
	moveZeroes4(test)
	moveZeroes4(test2)
}

// 从前往后找，遇到第一个0之后，找到这个0后的第一个非0，交换。时间复杂度O（N^2）
func moveZeroes(nums []int) {
	length, j := len(nums), 0
	if length < 2 {
		return
	}
	for i := 0; i < length; i++ {
		if nums[i] == 0 {
			// 这往后找第一个非0
			for j = i + 1; j < length; j++ {
				if nums[j] != 0 {
					nums[i], nums[j] = nums[j], nums[i]
					break
				}
			}
			if j == length {
				break
			}
		}
	}
}

// 维护一个计数器，[0, 1, 0, 3, 12]
// 遇到0，couter++, 遇到非零，i和i-counter交换，时间复杂度O（N）
func moveZeroes2(nums []int) {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			count++
		} else {
			nums[i-count], nums[i] = nums[i], nums[i-count]
		}
	}
}

// 计数非0，交换，时间复杂度O（N）
func moveZeroes3(nums []int) {
	pos := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[pos], nums[i] = nums[i], nums[pos]
			pos++
		}
	}
}

// 先移动，再填充0，时间复杂度O（N）
func moveZeroes4(nums []int) {
	pos := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			nums[pos] = nums[i]
			pos++
		}
	}
	for i := pos; i < len(nums); i++ {
		nums[i] = 0
	}
}
