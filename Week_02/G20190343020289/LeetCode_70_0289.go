package G20190343020289

//70. 爬楼梯
func climbStairs(n int) int {
	// f(n)=f(n-1)+f(n-2)
	// 倒爬楼梯
	// 超时
	//if n > 2 {
	//	return climbStairs(n-1) + climbStairs(n-2)
	//}
	//return n

	// 顺爬楼梯
	// 其他阶都是重复1,2
	// 超时
	//return climb(0,n)

	// 顺爬楼梯加缓存
	//if n <= 3 {
	//	return n
	//}
	//cache := make([]int, n+1)
	//return climb2(0, n, cache)

	// 迭代模拟爬楼梯
	// f(4)=f(3)+f(2)=f(2)+f(1)+f(2)
	if n <= 2 {
		return n
	}
	f1, f2, fi := 1, 2, 3
	for i := 3; i <= n; i++ {
		fi = f1 + f2
		f1 = f2
		f2 = fi
	}
	return fi
}

func climb(i, n int) int {
	if i > n {
		return 0
	}
	if i == n {
		return 1
	}
	return climb(i+1, n) + climb(i+2, n)
}

func climb2(i, n int, memory []int) int {
	if i > n {
		return 0
	}
	if i == n {
		return 1
	}
	if memory[i] > 0 {
		return memory[i]
	}
	memory[i] = climb2(i+1, n, memory) + climb2(i+2, n, memory)
	return memory[i]
}
