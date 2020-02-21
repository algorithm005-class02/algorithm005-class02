package main

import "sort"

func merge(intervals [][]int) [][]int {
	ret := [][]int{}
	sort.Slice(intervals, func(i, j int) bool { return intervals[i][0] < intervals[j][0] })
	for i := 0; i < len(intervals); i++ {
		leftSide, rightSide := intervals[i][0], intervals[i][1]
		for j := i + 1; j < len(intervals); i, j = i+1, j+1 {
			if rightSide < intervals[j][0] {
				break
			}
			if rightSide < intervals[j][1] {
				rightSide = intervals[j][1]
			}
		}
		ret = append(ret, []int{leftSide, rightSide})
	}
	return ret
}
