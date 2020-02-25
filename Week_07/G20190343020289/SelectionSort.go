package G20190343020289

// 快速排序
func selectionSort(arr []int) []int {
	length := len(arr)
	minIndex := 0
	for i := 0; i < length-1; i++ {
		minIndex = i
		for j := i + 1; j < length; j++ {
			if arr[j] < arr[minIndex] {
				minIndex = j
			}
		}
		arr[i], arr[minIndex] = arr[minIndex], arr[i]
	}
	return arr
}
