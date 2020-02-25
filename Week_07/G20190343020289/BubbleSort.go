package G20190343020289

// 冒泡排序
func bubbleSort(arr []int) []int {
	length := len(arr)
	for i := 0; i < length-1; i++ {
		for j := 0; j < length-1-i; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
			}
		}
	}
	return arr
}
