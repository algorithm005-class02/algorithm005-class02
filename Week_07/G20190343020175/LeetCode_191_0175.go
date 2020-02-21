package main

func hammingWeight(num uint32) int {
	oneCount := 0
	for num > 0 {
		num &= num - 1
		oneCount++
	}
	return oneCount
}
