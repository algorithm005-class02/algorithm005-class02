package main

import "fmt"

func generaterParenthesis(n int) []string {
	var res []string
	gen(&res, n, n, "")
	return res
}
func gen(res *[]string, left, right int, substr string) {
	//终止条件
	if left == 0 && right == 0 {
		*res = append(*res, substr)
		return
	}
	if left > 0 {
		gen(res, left-1, right, substr+"(")
	}
	if right > left {
		gen(res, left, right-1, substr+")")
	}
}

func main() {
	res := generaterParenthesis(3)
	fmt.Printf("res:%v\n", res)
}
