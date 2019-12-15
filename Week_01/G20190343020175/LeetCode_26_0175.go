package main

func removeDuplicates(nums []int) int {
	pos := 0
	for i := 1; i < len(nums); i++ {
		if nums[pos] != nums[i] {
			pos++
			nums[pos] = nums[i]
		}
	}
	return pos + 1
}

/*
func main() {
	nums := []int{1, 1, 2}
	newCount := removeDuplicates(nums)
	fmt.Println(nums, newCount)

	nums = []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	newCount = removeDuplicates(nums)
	fmt.Println(nums, newCount)
}
*/
