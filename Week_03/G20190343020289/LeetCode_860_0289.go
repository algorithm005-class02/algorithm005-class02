package G20190343020289

//860. 柠檬水找零
func lemonadeChange(bills []int) bool {
	// 贪心算法
	// 找零方案有：10 = (5) + 5，20 = (10+5) + 5 = (5+5+5) + 5，其中小括号中是找零部分
	// 贪心策略为：尽可能多的留5元在手上
	// 模拟过程为：
	//	付 5 元：记录；
	//	付 10 元： 找 5 元；
	//	付 20 元： 优先找 10+5 组合，若没有则找 5+5+5 组合。
	// 终止条件：若手上没有足够的零钱，则直接返回，若全部收完则返回true
	five, ten := 0, 0
	for _, v := range bills {
		if v == 5 {
			five++
		} else if v == 10 {
			if five == 0 {
				return false
			}
			five--
			ten++
		} else {
			if ten > 0 && five > 0 {
				ten--
				five--
			} else if five > 2 {
				five -= 3
			} else {
				return false
			}
		}
	}
	return true
}
