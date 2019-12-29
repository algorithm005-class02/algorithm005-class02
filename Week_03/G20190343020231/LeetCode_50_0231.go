package G20190343020231

// 1. 暴力，不断的乘以自己
// 2. 分治
// 3. 牛顿迭代法

// 递归，分治
func myPow1(x float64, n int) float64 {
	if n < 0 {
		return 1 / myPow(x, -n)
	}
	// terminator
	if n == 0 {
		return 1.0
	}
	if n == 1 {
		return x
	}

	// drill down
	res := myPow(x, n >> 1)
	if n & 1 == 1 {
		// 奇数
		return res * res * x
	}
	return res * res
}


// 2. 迭代，分治，位运算
func myPow(x float64, n int) float64 {
	cur := x
	temp := n
	if temp < 0 {
		temp = -temp
	}
	res := 1.0
	for temp != 0 {
		if temp & 1 == 1 {
			res = res * cur
		}
		cur = cur * cur
		temp >>= 1
	}

	if n < 0 {
		return 1 / res
	}

	return res
}
