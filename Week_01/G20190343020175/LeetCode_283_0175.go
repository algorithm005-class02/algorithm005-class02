package main

func moveZeroes(nums []int) {
	zeroCount := 0
	for i, v := range nums {
		if 0 == v {
			zeroCount++
		} else {
			if zeroCount > 0 {
				nums[i-zeroCount] = nums[i]
				nums[i] = 0
			}
		}
	}
}

/*
func main() {
	nums := []int{0, 1, 0, 3, 12}
	moveZeroes(nums)
	fmt.Println(nums)
}
*/
