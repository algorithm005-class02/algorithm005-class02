package main

func towSumBruteForce(nums []int, target int) []int {
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return []int{}
}

func twoSumTwoPassHashTable(nums []int, target int) []int {
	var numsMap = make(map[int]int)
	for i, num := range nums {
		numsMap[num] = i
	}

	for i, num := range nums {
		pos, ok := numsMap[target-num]
		if ok && pos != i {
			return []int{i, pos}
		}
	}

	return []int{}
}

func twoSumOnePassHashTable(nums []int, target int) []int {
	numsMap := make(map[int]int)

	for i, num := range nums {
		pos, ok := numsMap[target-num]
		if ok && pos != i {
			return []int{i, pos}
		}
		numsMap[num] = i
	}

	return []int{}
}

/*
func main() {
	result := towSumBruteForce([]int{2, 7, 11, 15}, 9)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{0, 1}))

	result = towSumBruteForce([]int{3, 2, 4}, 6)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{1, 2}))

	result = twoSumTwoPassHashTable([]int{2, 7, 11, 15}, 9)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{0, 1}))

	result = twoSumTwoPassHashTable([]int{3, 2, 4}, 6)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{1, 2}))

	result = twoSumOnePassHashTable([]int{2, 7, 11, 15}, 9)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{0, 1}))

	result = twoSumOnePassHashTable([]int{3, 2, 4}, 6)
	sort.Ints(result)
	fmt.Println(reflect.DeepEqual(result, []int{1, 2}))
}
*/
