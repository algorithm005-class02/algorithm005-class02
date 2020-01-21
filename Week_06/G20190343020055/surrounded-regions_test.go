package week06

func solve(board [][]byte) {
	if nil == board {
		return
	}
	if len(board) == 0 {
		return
	}
	ufs := NewUnoinFindSet(board)
	ufs.solve()
}

type UnoinFindSet struct {
	board [][]byte
}

func NewUnoinFindSet(board [][]byte) *UnoinFindSet {
	ufs := UnoinFindSet{}
	ufs.board = board
	return &ufs
}

func (ufs *UnoinFindSet) find(x, y int) byte {
	return ufs.board[x][y]
}

func (ufs *UnoinFindSet) union(x, y int) {
	if x < 0 || x >= len(ufs.board) || y < 0 || y >= len(ufs.board[0]) {
		return
	}

	if ufs.find(x, y) != 'Y' {
		return
	}

	ufs.board[x][y] = 'O'
	ufs.union(x-1, y)
	ufs.union(x+1, y)
	ufs.union(x, y-1)
	ufs.union(x, y+1)
}

func (ufs *UnoinFindSet) solve() {
	//先将所有的O都替换成Y
	for i := 0; i < len(ufs.board); i++ {
		for j := 0; j < len(ufs.board[0]); j++ {
			if ufs.board[i][j] == 'O' {
				ufs.board[i][j] = 'Y'
			}
		}
	}

	//从边界开始，合并相邻的Y并标记为O
	xSet, ySet := []int{0, len(ufs.board) - 1}, []int{0, len(ufs.board[0]) - 1}
	for _, x := range xSet {
		for y := 0; y < len(ufs.board[0]); y++ {
			ufs.union(x, y)
		}
	}
	for _, y := range ySet {
		for x := 0; x < len(ufs.board); x++ {
			ufs.union(x, y)
		}
	}

	//将剩余的Y标记为X
	for i := 0; i < len(ufs.board); i++ {
		for j := 0; j < len(ufs.board[0]); j++ {
			if ufs.board[i][j] == 'Y' {
				ufs.board[i][j] = 'X'
			}
		}
	}

}
