package main

// 1. 使用一个栈，时间复杂度O(n)，空间复杂度O(n)
func isValid(s string) bool {
	cache := map[byte]byte {')' : '(', ']': '[', '}': '{'}
	stack := []byte{}
	for i := 0; i < len(s); i++ {
		if s[i] == '(' || s[i] == '[' || s[i] == '{' {
			stack = append(stack, s[i]) // push
		} else {
			// } ] )
			// 如果栈里没有匹配的或者匹配不上，直接返回false
			if len(stack) == 0 ||  cache[s[i]] != stack[len(stack) - 1] {
				return false
			}
			// 能匹配上就pop
			stack = stack[:len(stack)-1]
		}
	}
	return len(stack) == 0
}

func isValid2(s string) bool {
	stack := make([]rune, 0)
	parentheses := map[rune]rune{')': '(', ']': '[', '}': '{'}
	for _, char := range s {
		if char == '{' || char == '(' || char == '[' {
			stack = append(stack, char)
		} else if len(stack) > 0 && parentheses[char] == stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		} else {
			return false
		}
	}
	return len(stack) == 0
}