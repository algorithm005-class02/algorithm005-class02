package main

import "fmt"

var num2Letter map[byte]string

func init() {
	num2Letter = make(map[byte]string)
	num2Letter['2'] = "abc"
	num2Letter['3'] = "def"
	num2Letter['4'] = "ghi"
	num2Letter['5'] = "jkl"
	num2Letter['6'] = "mno"
	num2Letter['7'] = "pqrs"
	num2Letter['8'] = "tuv"
	num2Letter['9'] = "wxyz"
}

func letterCombinations(digits string) []string {
	result := []string{}
	generate(0, digits, "", &result)
	return result
}

func generate(pos int, digits string, combination string, result *[]string) {
	fmt.Println(pos, combination)
	if pos == len(digits) {
		*result = append(*result, combination)
		return
	}

	for _, v := range num2Letter[digits[pos]] {
		generate(pos+1, digits, combination+string([]rune{v}), result)
	}
}
