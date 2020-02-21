package week03

func myPow(x float64, n int) float64 {

	if n < 0 {
		n = -n
		x = 1 / x
	}

	return fastPow(x, n)
}

func fastPow(x float64, n int) float64 {

	if n == 0 {
		return 1.0
	}

	half := fastPow(x, n/2)

	if n%2 == 0 {
		return half * half
	}

	return half * half * x
}
