package main

import (
	"math"
)

func myAtoi(str string) int {
	// Empty string
	if len(str) == 0 {
		return 0
	}

	index, sign, total := 0, 1, 0

	// Skip spaces
	for i := 0; i < len(str) && ' ' == str[i]; i++ {
		index++
	}
	if len(str) <= index {
		return 0
	}

	// Handle sign
	if str[index] == '-' || str[index] == '+' {
		if str[index] == '-' {
			sign = -1
		}
		index++
	}

	// Convert number and avoid overflow
	for index < len(str) {
		digit := int(str[index] - '0')
		if digit < 0 || 9 < digit {
			break
		}

		// Check if total will be overflow after 10 times and add digit
		if math.MaxInt32/10 < total ||
			math.MaxInt32/10 == total && math.MaxInt32%10 < digit {
			if sign == 1 {
				return math.MaxInt32
			}
			return math.MinInt32
		}

		total = 10*total + digit
		index++
	}

	return total * sign
}
