package leetcode

import "math"

/*
 * @lc app=leetcode.cn id=8 lang=golang
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
func myAtoi(str string) int {
	sLen := len(str)
	if sLen == 0 {
		return 0
	}
	i := 0
	for i < sLen && str[i] == ' ' {
		i++
	}
	sign := 1
	if i < sLen {
		if str[i] == '+' {
			i++
		} else if str[i] == '-' {
			sign = -1
			i++
		}
	} else {
		return 0
	}
	ret := 0
	for i < sLen && str[i] >= '0' && str[i] <= '9' {
		ret = ret*10 + int(str[i]) - '0'
		if sign*ret > math.MaxInt32 {
			return math.MaxInt32
		} else if sign*ret < math.MinInt32 {
			return math.MinInt32
		}
		i++
	}

	return sign * ret
}

// @lc code=end
