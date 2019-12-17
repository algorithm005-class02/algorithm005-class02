package main

import "fmt"

func main() {
	test1 := []int{3, 6, 7}
	test2 := []int{9, 9, 9}
	test3 := []int{0}
	test4 := []int{3, 9, 9}
	test5 := []int{3, 4, 9}
	test6 := []int{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6}
	fmt.Println(plusOne(test1))
	fmt.Println(plusOne(test2))
	fmt.Println(plusOne(test3))
	fmt.Println(plusOne(test4))
	fmt.Println(plusOne(test5))
	fmt.Println(plusOne(test6))

	fmt.Println()
	//fmt.Println(plusOne2(test1))
	//fmt.Println(plusOne2(test2))
	//fmt.Println(plusOne2(test3))
	//fmt.Println(plusOne2(test4))
	//fmt.Println(plusOne2(test5))
	//fmt.Println(plusOne2(test6))
	fmt.Println(test5)
}


// 1. 转换成数字，再加1，会溢出
// 2. 没有修改原数组。时间负载度O(N)，空间复杂度O(N)
//执行用时 :0 ms, 在所有 golang 提交中击败了100.00%的用户
//内存消耗 :2.1 MB, 在所有 golang 提交中击败了99.56%的用户
func plusOne(digits []int) []int {
	res := make([]int, len(digits)+1)
	length := len(digits)
	jinwei := 0
	for i := length - 1; i >= 0; i-- {
		if i == length-1 {
			jinwei = (digits[i] + 1) / 10
			res[i+1] = (digits[i] + 1) % 10
			continue
		}
		res[i+1] = (digits[i] + jinwei) % 10
		jinwei = (digits[i] + jinwei) / 10
	}
	if jinwei > 0 {
		res[0] = jinwei
	} else {
		// 去掉开头的0
		res = res[1:]
	}
	return res
}

// 3. 如果不是999，复用原数组；时间复杂度O(N)，空间复杂度O(N)
func plusOne2(digits []int) []int {
	for i := len(digits) - 1; i >= 0; i-- {
		digits[i] = digits[i] + 1
		digits[i] = digits[i] % 10
		if digits[i] != 0 {
			return digits
		}
	}
	res := make([]int, len(digits)+1)
	res[0] = 1
	return res
}