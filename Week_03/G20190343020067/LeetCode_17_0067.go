package main

import (
	"fmt"
)

var phone = map[string]string{
	"2": "abc",
	"3": "def",
	"4": "ghi",
	"5": "jkl",
	"6": "mno",
	"7": "pqrs",
	"8": "tuv",
	"9": "wxyz",
}

var output []string

func backtrack(combination string, digits string, i int) {
	// terminator
	if len(digits) == i {
		output = append(output, combination)
		return
	}
	//process
	letters := phone[digits[i:i+1]]

	for j := 0; j < len(letters); j++ {
		backtrack(combination+letters[j:j+1], digits, i+1)
	}
}

func letterCombinations(digits string) []string {
	if len(digits) != 0 {
		backtrack("", digits, 0)
	}

	return output
}

func main() {
	res := letterCombinations("23")
	fmt.Println(res)
}
