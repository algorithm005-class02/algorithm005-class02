package leetcode

import (
	"strings"
)

/*
 * @lc app=leetcode.cn id=51 lang=golang
 *
 * [51] N皇后
 */

// @lc code=start

type statesNQueens struct {
	Cols   map[int]bool
	A45    map[int]bool
	A135   map[int]bool
	N      int
	Result [][]int
}

func (s *statesNQueens) CanPut(row, col int) bool {
	return !s.Cols[col] && !s.A45[row+col] && !s.A135[row-col]
}

func (s *statesNQueens) DFS(row int, curState []int) {
	if row >= s.N {
		s.Result = append(s.Result, curState)
		return
	}
	for col := 0; col < s.N; col++ {
		if s.CanPut(row, col) {
			s.Cols[col] = true
			s.A45[row+col] = true
			s.A135[row-col] = true
			midState := make([]int, 0, s.N)
			midState = append(midState, curState...)
			s.DFS(row+1, append(midState, col))
			delete(s.Cols, col)
			delete(s.A45, row+col)
			delete(s.A135, row-col)
		}
	}
}

func (s *statesNQueens) ToResult() [][]string {
	result := make([][]string, 0, s.N)
	for _, r := range s.Result {
		mR := make([]string, 0, s.N)
		for _, p := range r {
			var sb strings.Builder
			for i := 0; i < s.N; i++ {
				if i == p {
					sb.WriteString("Q")
				} else {
					sb.WriteString(".")
				}
			}
			mR = append(mR, sb.String())
		}
		result = append(result, mR)
	}
	return result
}

func solveNQueens(n int) [][]string {
	cols := map[int]bool{}
	a45 := map[int]bool{}
	a135 := map[int]bool{}
	st := &statesNQueens{
		Cols:   cols,
		A45:    a45,
		A135:   a135,
		N:      n,
		Result: [][]int{},
	}

	st.DFS(0, []int{})
	return st.ToResult()
}

// @lc code=end
