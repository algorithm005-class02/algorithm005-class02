package main

func searchMatrix(matrix [][]int, target int) bool {
	if nil == matrix || 0 == len(matrix) || 0 == len(matrix[0]) {
		return false
	}

	rowNum, colNum := len(matrix), len(matrix[0])
	lo, hi := 0, rowNum*colNum-1

	for lo <= hi {
		mid := (lo + hi) / 2
		if target == matrix[mid/colNum][mid%colNum] {
			return true
		} else if target > matrix[mid/colNum][mid%colNum] {
			lo = mid + 1
		} else {
			hi = mid - 1
		}
	}

	return false
}
