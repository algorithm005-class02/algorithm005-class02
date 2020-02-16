package main

import (
	"fmt"
	"math"
	"strconv"
	"strings"
)

// 处理各种边界条件
func main() {
	fmt.Println(myAtoi("- 234"))
	fmt.Println(myAtoi("20000000000000000000"))
	fmt.Println(myAtoi("  -0012a42"))
	fmt.Println(myAtoi("+"))
	fmt.Println(myAtoi(""))
	fmt.Println(myAtoi("+-2"))
	fmt.Println(myAtoi("abc"))
	fmt.Println(myAtoi("3.14159"))
	fmt.Println(myAtoi(".94159"))
	fmt.Println(myAtoi("34abc"))
	fmt.Println(myAtoi("+42"))
	fmt.Println(myAtoi("42"))
	fmt.Println(myAtoi("-42"))
	fmt.Println(myAtoi("            -42"))
	fmt.Println(myAtoi("-4237 23 with words"))

	fmt.Println(myAtoi("-91283472332"))
	fmt.Println(myAtoi("91283472332"))
}

// 全面考虑各种条件
func myAtoi(str string) int {
	// 不需要转换的条件
	// 有多余字符要去掉
	// 正负号处理
	// 转换后的数字大小不越界
	str = strings.TrimSpace(str)
	if len(str) == 0 {
		return 0
	}
	negative := 1
	temp := str
	// 处理去除空格后的第一个字符
	if str[0] == '-' {
		negative = -1
		temp = str[1:]
	} else if str[0] == '+' {
		temp = str[1:]
	} else if str[0] == '.' {
		return 0
	} else if str[0] < '0' || str[0] > '9' {
		return 0
	}
	if len(temp) == 0 {
		return 0
	}

	res := strings.Split(temp, " ")
	temp = res[0]
	// 处理第一个字符是空格

	// 处理+-2
	if len(temp) == 0 || temp[0] < '0' || temp[0] > '9' {
		return 0
	}
	// 数字中可能夹杂着字母
	for i := 0; i < len(temp); i++ {
		if temp[i] < '0' || temp[i] > '9' {
			temp = temp[:i]
			break
		}
	}
	// 处理浮点数
	floatIdx := strings.Index(temp, ".")
	if floatIdx > 0 {
		temp = temp[:floatIdx]
	}
	num, err := strconv.Atoi(temp)
	// 处理越界
	if err != nil || num > math.MaxInt32 {
		if negative == 1 {
			return math.MaxInt32
		}
		return math.MinInt32
	}
	return negative * num
}

