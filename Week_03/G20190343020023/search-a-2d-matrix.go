func searchMatrix(matrix [][]int, target int) bool {
    if len(matrix) < 1 || len(matrix[0]) < 1 {
        return false
    }
    left, right := 0, len(matrix) - 1
    for left <= right {
        mid := left + (right - left) / 2
        tmp := matrix[mid]
        if tmp[0] > target {
            right = mid - 1
        } else if tmp[len(tmp) - 1] < target {
            left = mid + 1
        } else {
            nLeft, nRight := 0, len(tmp) - 1
            for nLeft <= nRight {
                nMid := nLeft + (nRight - nLeft) / 2
                if tmp[nMid] == target {
                    return true
                } else if tmp[nMid] > target {
                    nRight = nMid - 1
                } else {
                    nLeft = nMid + 1
                }
            }
            return false
        }
    }
    return false
}