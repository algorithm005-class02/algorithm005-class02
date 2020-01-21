package main

import (
	"fmt"
)

func main() {
	fmt.Println(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log", "cog"}))
	fmt.Println(ladderLength("hit", "cog", []string{"hot", "dot", "dog", "lot", "log"}))
	fmt.Println(ladderLength("hot", "dog", []string{"hot", "dog", "dot"}))
	fmt.Println(ladderLength("hot", "dog", []string{"hot", "dog"}))
	fmt.Println(ladderLength("a", "c", []string{"a", "b", "c"}))

	fmt.Println()

	fmt.Println(ladderLength2("hit", "cog", []string{"hot", "dot", "dog", "lot", "log", "cog"}))
	fmt.Println(ladderLength2("hit", "cog", []string{"hot", "dot", "dog", "lot", "log"}))
	fmt.Println(ladderLength2("hot", "dog", []string{"hot", "dog", "dot"}))
	fmt.Println(ladderLength2("hot", "dog", []string{"hot", "dog"}))
	fmt.Println(ladderLength2("a", "c", []string{"a", "b", "c"}))
}

// 单向BFS 时间复杂度
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// 先判断endWord是否在wordList中
	flag := false
	for i := 0; i < len(wordList); i++ {
		if endWord == wordList[i] {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}
	wordLen := len(wordList[0]) // 单词长度
	// 预处理，将wordList构造查找字典，空间换时间
	lookupDic := make(map[string][]string)
	key, word := "", ""
	for i := 0; i < len(wordList); i++ { // 字典中可能包含起始单词
		word = wordList[i]
		if word == beginWord {
			continue
		}
		for j := 0; j < wordLen; j++ {
			key = word[:j] + "*" + word[j+1:]
			lookupDic[key] = append(lookupDic[key], word) // 直接append
		}
	}
	// BFS搜索
	queue := []string{beginWord}
	visited := make(map[string]struct{})
	visited[beginWord] = struct{}{}
	res := 0
	for len(queue) > 0 {
		res++
		length := len(queue)
		for k := 0; k < length; k++ {
			tempStr := queue[0]
			queue = queue[1:]
			for i := 0; i < len(tempStr); i++ {
				key = tempStr[:i] + "*" + tempStr[i+1:]
				for _, str := range lookupDic[key] {
					if str == endWord {
						return res + 1 // 找到路径
					}
					if _, ok := visited[str]; !ok {
						queue = append(queue, str)
						visited[str] = struct{}{}
					}
				}
			}
		}
	}
	return 0 // 没找到路径
}

// 双向BFS，从a到z进行尝试
func ladderLength2(beginWord string, endWord string, wordList []string) int {
	// 先判断endWord是否在wordList中
	flag := false
	for i := 0; i < len(wordList); i++ {
		if endWord == wordList[i] {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}
	// 将wordList转换成map
	wordListMap := make(map[string]struct{}, len(wordList))
	for _, str := range wordList {
		wordListMap[str] = struct{}{}
	}
	beginSet, endSet := make(map[string]struct{}), make(map[string]struct{})
	beginSet[beginWord], endSet[endWord] = struct{}{}, struct{}{}
	lenCount := 1
	visited := make(map[string]struct{})
	for len(beginSet) != 0 && len(endSet) != 0 {
		if len(beginSet) > len(endSet) {
			beginSet, endSet = endSet, beginSet // 从小的开始找
		}
		temp := make(map[string]struct{})
		for word, _ := range beginSet {
			for i := 0; i < len(word); i++ {
				// 尝试对word用a-z来进行替换
				for j := 'a'; j <= 'z'; j++ {
					newStr := word[:i] + string(j) + word[i+1:]
					if _, ok := endSet[newStr]; ok {
						return lenCount + 1
					}
					_, ok1 := visited[newStr]
					_, ok2 := wordListMap[newStr]
					if !ok1 && ok2 {
						temp[newStr], visited[newStr] = struct{}{}, struct{}{}
					}
				}
			}
		}
		beginSet = temp
		lenCount++
	}
	return 0
}
