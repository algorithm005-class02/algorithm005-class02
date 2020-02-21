package G20190343020289

//func myPow(x float64, n int) float64 {
//	// 暴力法
//	// n分正负两种情况,为负时，n要取正，x取倒数
//	// leetcode超时
//	N := n
//	if n < 0 {
//		x = 1 / x
//		N = -n
//	}
//	ans := float64(1)
//	for i := 0; i < N; i++ {
//		ans = ans * x
//	}
//	return ans
//}

func myPow(x float64, n int) float64 {
	// 递归
	// x^(n)=x^(n/2)*x^(n/2)
	// 缩小n,最终n会缩小到0
	// 如果n为基数 还需要在乘一次x
	if n < 0 {
		x = 1 / x
		n = -n
	}
	return fastPow(x, n)
}

func fastPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	half := fastPow(x, n/2)
	if n%2 == 0 {
		return half * half
	} else {
		return half * half * x
	}
}
