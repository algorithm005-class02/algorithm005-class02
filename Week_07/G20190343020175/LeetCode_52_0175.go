package main

func totalNQueens(n int) int {
	ret := 0
	dfsII(0, n, 0, 0, 0, &ret)
	return ret
}

func dfsII(row, queenCount int, cols, dalas, hills uint32, count *int) {
	if row >= queenCount {
		(*count)++
		return
	}

	bits := (^(cols | dalas | hills)) & ((uint32(1) << uint32(queenCount)) - 1)

	for bits != 0 {
		p := bits & (-bits)
		bits &= bits - 1
		dfsII(row+1, queenCount, cols|p, (dalas|p)<<1, (hills|p)>>1, count)
	}
}
