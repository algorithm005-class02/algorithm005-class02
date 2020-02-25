package G20190343020289

// 插入排序
func insertionSort(arr []int) []int {
	length := len(arr)
	preIndex := 0
	current := 0
	for i := 1; i < length; i++ {
		preIndex = i - 1
		current = arr[i]
		for preIndex >= 0 && arr[preIndex] > current {
			arr[preIndex+1] = arr[preIndex]
			preIndex--
		}
		arr[preIndex+1] = current
	}
	return arr
}
