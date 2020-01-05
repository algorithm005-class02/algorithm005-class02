package main

func maxProfit(prices []int) int {
	total := 0
	for i := 0; i < len(prices)-1; i++ {
		if prices[i+1] > prices[i] {
			total += prices[i+1] - prices[i]
		}
	}
	return total
}
