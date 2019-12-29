package main

func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for _, c := range bills {
		if c == 5 {
			five++
		} else if c == 10 {
			five, ten = five-1, ten+1
		} else {
			if ten > 0 {
				ten, five = ten-1, five-1
			} else {
				five -= 3
			}
		}
		if five < 0 {
			return false
		}
	}
	return true
}
