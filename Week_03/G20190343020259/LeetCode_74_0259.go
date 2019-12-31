package G20190343020259

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) < 1 {
		return false
	}

	row, column := len(matrix), len(matrix[0])
	left, right := 0, row * column - 1

	for left <= right {
		mid := left + (right - left) / 2
		midNum := matrix[mid/column][mid%column]
		if midNum == target {
			return true
		}
		if midNum > target{
			right = mid
		} else {
			left = mid + 1
		}
	}

	return false
}
