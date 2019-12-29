package leetcode

/*
 * @lc app=leetcode.cn id=874 lang=golang
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
func robotSim(commands []int, obstacles [][]int) int {
	const turnLeft = -2
	const turnRight = -1
	dirMap := map[[2]int]([2][2]int){
		[2]int{1, 1}:  [2][2]int{[2]int{0, -1}, [2]int{0, 1}},
		[2]int{0, -1}: [2][2]int{[2]int{1, -1}, [2]int{1, 1}},
		[2]int{1, -1}: [2][2]int{[2]int{0, 1}, [2]int{0, -1}},
		[2]int{0, 1}:  [2][2]int{[2]int{1, 1}, [2]int{1, -1}},
	}
	obsMap := createObsMap(obstacles)
	pos := [2]int{0, 0}
	dir := [2]int{1, 1}
	var max int = 0
	for _, cmd := range commands {
		if cmd == turnLeft {
			dir = dirMap[dir][0]
		} else if cmd == turnRight {
			dir = dirMap[dir][1]
		} else {
			for i := 0; i < cmd; i++ {
				pos[dir[0]] += dir[1]
				if obsMap[pos] {
					pos[dir[0]] -= dir[1]
					break
				}
			}
		}
		area := pos[0]*pos[0] + pos[1]*pos[1]
		if area > max {
			max = area
		}
	}
	//fmt.Println(pos)
	return max
}

func createObsMap(obstacles [][]int) map[[2]int]bool {
	var obsMap map[[2]int]bool = make(map[[2]int]bool, len(obstacles))
	for _, obsVal := range obstacles {
		obsMap[[2]int{obsVal[0], obsVal[1]}] = true
	}
	return obsMap
}

// @lc code=end
