package main

import (
	"fmt"
	"strings"
)

// 1. 直接做，先去头尾空格，以空格进行trim，然后反转所有单词
// 2. 不使用库函数
// 2. 先去头尾空格，全部反转，在按空格反转一次每个单词
func main() {
	test1 := "a good   example"
	test2 := "the sky is blue"
	test3 := "  hello world!  "
	fmt.Println("a" + reverseWords(test1) + "b")
	fmt.Println("a" + reverseWords(test2) + "b")
	fmt.Println("a" + reverseWords(test3) + "b")
	fmt.Println("a" + reverseWords("") + "b")

	fmt.Println()
	fmt.Println("a" + reverseWords2(test1) + "b")
	fmt.Println("a" + reverseWords2(test2) + "b")
	fmt.Println("a" + reverseWords2(test3) + "b")
	fmt.Println("a" + reverseWords2("") + "b")
}

func reverseWords(s string) string {
	s1 := strings.TrimSpace(s)
	s2 := strings.Split(s1, " ")
	resArray := []string{}
	for i := len(s2) - 1; i >= 0; i-- {
		if strings.TrimSpace(s2[i]) != "" {
			resArray = append(resArray, s2[i])
		}
	}
	return strings.Join(resArray, " ")
}

// 不使用库函数
func reverseWords2(s string) string {
	//m, n := 0, len(s)-1
	temp := s
	idx := 0
	for idx < len(s) && temp[idx] == ' ' {
		idx++
	}
	temp = temp[idx:]
	idx = len(temp) - 1
	for idx >= 0 && temp[idx] == ' ' {
		idx--
	}
	temp = temp[:idx+1] // 去掉左右空格
	res := ""
	idx = len(temp) - 1
	// 从后往前
	for i := len(temp) - 1; i >= 0; i-- {
		if temp[i] == ' ' {
			// 找到下一个单词首字母
			res += temp[i+1:idx+1] + " "
			for j := i - 1; j >= 0; j-- {
				if temp[j] != ' ' {
					i, idx = j, j // 跳过多余空格
					break
				}
			}
		}
		if i == 0 {
			res += temp[i : idx+1]
		}
	}
	return res
}
