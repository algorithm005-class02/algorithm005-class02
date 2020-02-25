package G20190343020289

import "sort"

//56. 合并区间
func merge(intervals [][]int) [][]int {
	// 先进行排序
	// 然后遍历获得区间关系
	l := len(intervals)
	if l <= 0 {
		return [][]int{}
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	res := make([][]int, 0)
	left := intervals[0][0]
	right := intervals[0][1]
	for i := 1; i < l; i++ {
		if intervals[i][0] <= right {
			if intervals[i][1] > right {
				right = intervals[i][1]
			}
		} else {
			res = append(res, []int{left, right})
			left = intervals[i][0]
			right = intervals[i][1]
		}
	}
	res = append(res, []int{left, right})
	return res
}
