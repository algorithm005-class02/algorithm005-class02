package main

import (
	"fmt"
)

func main() {
	input1 := [][]byte{[]byte{'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'}, []byte{'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'}, []byte{'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'}, []byte{'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'}, []byte{'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, []byte{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}}
	fmt.Println("input1", len(input1), len(input1[0]))
	input2 := [][]byte{[]byte{'1', '1', '0', '0', '0'}, []byte{'1', '1', '0', '0', '0'}, []byte{'0', '0', '1', '0', '0'}, []byte{'0', '0', '0', '1', '1'}}
	input3 := [][]byte{[]byte{'1'}}
	input4 := [][]byte{[]byte{'0'}, []byte{'0'}, []byte{'0'}}
	input5 := [][]byte{[]byte{'1', '0', '0'}, []byte{'0', '0', '0'}, []byte{'0', '0', '1'}}
	input6 := [][]byte{[]byte{'0', '0', '0', '1'}}
	fmt.Println(numIslands(input1))
	fmt.Println(numIslands(input2))
	fmt.Println(numIslands(input3))
	fmt.Println(numIslands(input4))
	fmt.Println(numIslands(input5))
	fmt.Println(numIslands(input6))
	fmt.Println()
	fmt.Println(numIslands2(input1))
	fmt.Println(numIslands2(input2))
	fmt.Println(numIslands2(input3))
	fmt.Println(numIslands2(input4))
	fmt.Println(numIslands2(input5))
	fmt.Println(numIslands2(input6))
}

/*********并查集实现*********/

type UF struct {
	count int
	data  []int
}

func MakeUF(grid [][]byte) *UF {
	nr := len(grid)
	nc := len(grid[0])
	temp := make([]int, nr*nc)
	cnt := 0
	for i := 0; i < nr; i++ {
		for j := 0; j < nc; j++ {
			if grid[i][j] == '1' {
				temp[i*nc+j] = i*nc + j
				cnt++
			}
		}
	}
	return &UF{
		count: cnt,
		data:  temp,
	}
}

func (uf *UF) Union(p int, q int) {
	rootA := uf.FindRoot(p)
	rootB := uf.FindRoot(q)
	if rootA != rootB {
		uf.data[rootA] = rootB //union
		uf.count--
	}
}

// 找到根并做路径压缩
func (uf *UF) FindRoot(p int) int {
	root := p
	// 先找到根
	for root != uf.data[root] {
		root = uf.data[root]
	}
	// 找到根后做路径压缩，将路径上的点都指向根
	temp := p
	for temp != uf.data[temp] {
		par := uf.data[temp]
		uf.data[temp], temp = root, par
	}
	return root
}

func (uf *UF) Connected(p int, q int) bool {
	return uf.FindRoot(p) == uf.FindRoot(q)
}

func (uf *UF) Count() int {
	return uf.count
}

/******************/

// 并查集
func numIslands(grid [][]byte) int {
	// 将网格转换成一维
	nr := len(grid)
	if nr == 0 {
		return 0
	}
	nc := len(grid[0])
	uf := MakeUF(grid) // 用grid初始化

	// 四联通方向数组
	row, col := []int{-1, 1, 0, 0}, []int{0, 0, 1, -1}
	for i := 0; i < nr; i++ {
		for j := 0; j < nc; j++ {
			if grid[i][j] == '1' {
				for k := 0; k < 4; k++ {
					if i+row[k] >= 0 && i+row[k] < nr && j+col[k] >= 0 && j+col[k] < nc && grid[(i + row[k])][(j+col[k])] == '1' {
						// 合并
						uf.Union(i*nc+j, (i+row[k])*nc+(j+col[k]))
					}
				}
			}
		}
	}
	return uf.Count()
}

// BFS, flood fill
func numIslands2(grid [][]byte) int {
	if len(grid) == 0 || len(grid[0]) == 0 {
		return 0
	}
	res := 0
	nr, nc := len(grid), len(grid[0])
	dir := [4][2]int{[2]int{1, 0}, [2]int{-1, 0}, [2]int{0, 1}, [2]int{0, -1}}
	idx, row, col, dx, dy := 0, 0, 0, 0, 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				res++
				// flood fill
				queue := []int{i*nc + j}
				for len(queue) > 0 {
					idx = queue[0]
					queue = queue[1:]
					row, col = idx/nc, idx%nc
					grid[row][col] = '0'
					for k := 0; k < 4; k++ {
						dx, dy = row+dir[k][0], col+dir[k][1]
						if dx >= 0 && dx < nr && dy >= 0 && dy < nc && grid[dx][dy] == '1' {
							queue = append(queue, dx*nc+dy)
							grid[dx][dy] = '0'
						}
					}
				}
			}
		}
	}
	return res
}

// DFS flood fill
func numIslands3(grid [][]byte) int {
	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				res++
				helper(grid, i, j)
			}
		}
	}
	return res
}

func helper(grid [][]byte, i, j int) {
	nr, nc := len(grid), len(grid[0])
	if i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] == '0' {
		return
	}
	grid[i][j] = '0'
	helper(grid, i+1, j)
	helper(grid, i-1, j)
	helper(grid, i, j+1)
	helper(grid, i, j-1)
}
