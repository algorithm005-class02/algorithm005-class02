package week05

func maximalSquare(matrix [][]byte) int {

	sum := 0

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[i]); j++ {
			if matrix[i][j] == '1' {
				sum++
			}
		}
	}

	if sum == 0 {
		return 0
	}

	sideLength := 1
	for {

		for i := 0; i < len(matrix); i++ {
			for j := 0; j < len(matrix[0]); j++ {
				//判断是否符合边长加1的规则
				if i < len(matrix)-1 && j < len(matrix[0])-1 && matrix[i][j] == '1' && matrix[i][j+1] == '1' && matrix[i+1][j] == '1' && matrix[i+1][j+1] == '1' {
				} else {
					if matrix[i][j] == '1' {
						matrix[i][j] = '0'
						sum--
					}
				}
			}
		}

		if sum == 0 {
			break
		}

		sideLength++
	}
	return sideLength * sideLength
}
