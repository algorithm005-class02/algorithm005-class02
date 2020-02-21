package main

func majorityElement(nums []int) int {
	counts := make(map[int]int)

	for _, v := range nums {
		counts[v]++
	}

	for k, v := range counts {
		if v >= len(nums)/2 {
			return k
		}
	}

	return -1
}
