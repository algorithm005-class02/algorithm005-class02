package main

import "fmt"

//17.电话号码组合
//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
//思路：递归调用
var phone map[string]string = map[string]string{"2": "abc", "3": "def", "4": "ghi", "5": "jkl",
	"6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}

func lettercombinations(digits string) []string {
	if digits == "" || len(digits) == 0 {
		return nil
	}
	res := make([]string, 0)
	backtrack(&res, "", digits)
	return res
}

func backtrack(res *[]string, condition, nextDigits string) {
	if len(nextDigits) == 0 {
		*res = append(*res, condition)
	} else {
		digit := nextDigits[0:1]
		letters := phone[digit]
		for i := 0; i < len(letters); i++ {
			letter := letters[i : i+1]
			backtrack(res, condition+letter, nextDigits[1:])
		}
	}
}

func main() {
	str := "23"
	res := lettercombinations(str)
	fmt.Printf("%s\n", res)
}
