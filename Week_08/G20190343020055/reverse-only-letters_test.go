package week08

import (
	"fmt"
	"testing"
)

func reverseOnlyLetters(S string) string {

	var str, result string
	for i := len(S) - 1; i >= 0; i-- {
		ch := S[i]
		if isLetter(ch) {
			str += string(ch)
		}
	}

	for i, j := 0, 0; i < len(S); i++ {
		ch := S[i]

		if isLetter(ch) {
			result += string(str[j])
			j++
		} else {
			result += string(ch)
		}
	}
	return result
}

func isLetter(str byte) bool {
	var out bool
	if (str >= 'a' && str <= 'z') || (str >= 'A' && str <= 'Z') {
		out = true
	}
	return out
}

func TestReverseOnlyLetters(t *testing.T) {

	S := "a-bC-dEf-ghIj"
	res := reverseOnlyLetters(S)

	fmt.Println("输入：", S)
	fmt.Println("输出：", res)
}
