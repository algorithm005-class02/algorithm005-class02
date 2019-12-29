package week03

func maxProfit(prices []int) int {

	maxP := 0
	for i := 1; i < len(prices); i++ {

		if prices[i] > prices[i-1] {
			maxP += prices[i] - prices[i-1]
		}
	}
	return maxP
}
