package G20190343020231

// 1. 直接递归，指数级别
// 1.1 从上往下递归 (Time Out)
// 1.2 从下往上递归 (Time Out)
// 2. 递归+记忆化
// 3. DP
// 3.1 直接用二维数组
// 3.2 状态压缩，一维数组

// ---------- 1.1 -------- 从上往下递归
// func minimumTotal(triangle [][]int) int {
//     if len(triangle) == 0 {
//         return 0
//     }
//     res := 1 << 63 -1
//     helper(triangle, 0, 0, 0, &res)
//     return res
// }

// func helper(triangle [][]int, level int, col int, sum int, res *int) {
//     length := len(triangle)
//     // terminator
//     if level >= length || col >= length {
//         return
//     }
//     // process
//     sum = sum + triangle[level][col]
//     if level == length - 1 && *res > sum{
//         *res = sum
//         return
//     }
//     // drill down
//     helper(triangle, level+1, col, sum, res)
//     helper(triangle, level+1, col+1, sum, res)
// }


// 1.2 从下往上递归
// func minimumTotal(triangle [][]int) int {
//     length := len(triangle)
//     if length == 0 {
//         return 0
//     }
//     res := 1 << 63 -1
//     for i:=0; i<length; i++ {
//         helper(triangle, length-1, i, 0, &res)
//     }
//     return res
// }

// func helper(triangle [][]int, level int, col int, sum int, res *int) {
//     // terminator
//     if level < 0 || col < 0 || col > level {
//         return
//     }
//     // process
//     sum = sum + triangle[level][col]
//     if level == 0 && *res > sum{
//         *res = sum
//         return
//     }
//     // drill down
//     helper(triangle, level-1, col, sum, res)
//     helper(triangle, level-1, col-1, sum, res)
// }

// 1. 使用递归函数返回值做递归
// func minimumTotal(triangle [][]int) int {
//     if len(triangle) == 0 {
//         return 0
//     }
//     res := []int{}
//     helper(triangle, 0, 0, 0, &res)
//     final := 1 << 63 - 1
//     fmt.Println(res)
//     for _, val := range res {
//         if final > val {
//           final = val
//         }
//     }
//     return final
// }

// // 截止到level，以及col的最小sum
// func helper(triangle [][]int, level int, col int, sum int, res *[]int) int {
//     length := len(triangle)
//     // terminator
//     if level >= length || col >= length {
//         return sum
//     }
//     // process
//     sum = sum + triangle[level][col]
//     if level == length - 1 {
//         *res = append(*res, sum)
//         return sum
//     }
//     // drill down
//     sum1 := helper(triangle, level+1, col, sum, res)
//     sum2 := helper(triangle, level+1, col+1, sum, res)
//     if sum1 > sum2 {
//         return sum2
//     }
//     return sum1
// }

// 使用DP，一维数组做状态压缩
func minimumTotal(triangle [][]int) int {
	length := len(triangle)
	if length == 0 {
		return 0
	}
	dp := make([]int, length)
	for i:=0; i<length; i++ {
		dp[i] = triangle[length-1][i]
	}

	for i:= length-2; i>=0; i-- {
		for j:=0; j<=i; j++ {
			dp[j] = min(dp[j], dp[j+1]) +  triangle[i][j]
		}
	}
	return dp[0]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}