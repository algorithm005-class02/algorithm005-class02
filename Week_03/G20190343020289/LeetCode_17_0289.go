package G20190343020289

//17. 电话号码的字母组合
func letterCombinations(digits string) []string {
	ans := make([]string, 0)

	if digits == "" {
		return ans
	}

	digitsMaps := map[string][]string{
		"2": {"a", "b", "c"},
		"3": {"d", "e", "f"},
		"4": {"g", "h", "i"},
		"5": {"j", "k", "l"},
		"6": {"m", "n", "o"},
		"7": {"p", "q", "r", "s"},
		"8": {"t", "u", "v"},
		"9": {"w", "x", "y", "z"},
	}

	track := ""
	backtrack(digitsMaps, digits, 0, &ans, track)
	return ans
}

func backtrack(digitsMaps map[string][]string, digits string, idx int, ans *[]string, track string) {
	// 触发结束条件
	if len(digits) == len(track) {
		*ans = append(*ans, track)
		return
	}
	for _, val := range digitsMaps[string(digits[idx])] {
		// 这里会出现 digits=“22” 不用排除上一级已存在的元素
		//if strings.Index(track, val) > -1 {
		//	continue
		//}
		// 做选择
		track += val
		// 进入下一层决策树
		backtrack(digitsMaps, digits, idx+1, ans, track)
		// 回溯到上一层，取消选择
		track = track[:len(track)-1]
	}
}
