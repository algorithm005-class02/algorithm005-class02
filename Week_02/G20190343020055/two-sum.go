
func twoSum(nums []int, target int) []int {

	m := make(map[int]int)

	for index := 0; index < len(nums); index++ {

		b := target - nums[index]

		if j, ok := m[b]; ok {

			return []int{j, index}
		} else {
			m[nums[index]] = index
		}
	}

	return nil
}
