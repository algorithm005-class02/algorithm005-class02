package main

// 1. 使用暴力，对于n对，可以生成2n个位置，对于每一个位置，可以是(或者)
// 2. 递归
func generateParenthesis(n int) []string {
	res := []string{}
	helper(n, n, n, "", &res)
	return res
}

func helper(n int, left int, right int, curStr string, res *[]string) {
	// terminator
	if left > right {
		return
	}
	// process data
	if left == 0 && right == 0 {
		*res = append(*res, curStr)
		return
	}

	// drill down
	if left >= 1 {
		helper(n, left-1, right, curStr+"(", res)
	}
	if right >= 1 {
		helper(n, left, right-1, curStr+")", res)
	}
	// clear status
}