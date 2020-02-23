func groupAnagrams(strs []string) [][]string {

	var maps []map[int32]int
	if strs != nil {
		tmpMap := make(map[int32]int)
		for _,v := range strs[0] {
			tmpMap[v] ++
		}
		maps = append(maps, tmpMap)
	}
	//默认不存在
	var tStrings [][]string
	fstrs := []string{strs[0]}
	tStrings = append(tStrings,fstrs)
	var pos int
	isExist := false
	for i, vac := range strs {
		if i == 0 {
			continue
		}
		//默认不存在
		isExist = false
		//记录maps和strings下标一一对应
		//根据单词string创建map
		tmpMap := make(map[int32]int)
		for _,v := range vac {
			tmpMap[v] ++
		}
		pos=0
		//比较maps列表，查询是否存在
		for _, imaps := range maps {
			if reflect.DeepEqual(imaps, tmpMap) {
				isExist=true
				break
			}
			pos++
		}
		//如果没有找到，新建一个map，和string数组
		if isExist == false {
			maps = append(maps, tmpMap)
			str := []string{vac}
			tStrings = append(tStrings, str)
		} else {
			tStrings[pos] = append(tStrings[pos], vac)
		}
	}
	return tStrings
}