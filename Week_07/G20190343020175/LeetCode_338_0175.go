package main

func countBits(num int) []int {
	ret := make([]int, num+1)

	for i := 0; i <= num; i++ {
		ret[i] = ret[i>>1] + i%2
	}

	return ret
}
