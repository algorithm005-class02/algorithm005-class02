package G20190343020289

//22. 括号生成
func generateParenthesis(n int) []string {
	return recur(0, 0, n, "")
}

func recur(left, right, n int, s string) []string {
	if left == n && right == n {
		return []string{s}
	}

	result := make([]string, 0)
	if left < n {
		result = append(result, recur(left+1, right, n, s+"(")...)
	}
	if left > right {
		result = append(result, recur(left, right+1, n, s+")")...)
	}
	return result
}
