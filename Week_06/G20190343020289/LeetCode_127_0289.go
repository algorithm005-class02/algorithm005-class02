package G20190343020289

//127. 单词接龙
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// BFS+预处理
	// wordList中没有endWord的直接排除 返回0
	flag := false
	for _, word := range wordList {
		if word == endWord {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}
	visited := make(map[string]bool)
	queue := []string{beginWord}
	level := 0
	wordLen := len(beginWord)
	// 预处理数据
	// 使用*替换字母，并把相同的字符串分组存入字典
	wordListDic := make(map[string][]string)
	for _, word := range wordList {
		for i := 0; i < wordLen; i++ {
			key := word[:i] + "*" + word[i+1:]
			wordListDic[key] = append(wordListDic[key], word)
		}
	}
	for len(queue) > 0 {
		level++
		newQueue := queue[len(queue):]
		for _, item := range queue {
			for i := 0; i < wordLen; i++ {
				key := item[:i] + "*" + item[i+1:]
				for _, word := range wordListDic[key] {
					if word == endWord {
						return level + 1
					}
					if !visited[word] {
						visited[word] = true
						newQueue = append(newQueue, word)
					}
				}
			}
		}
		queue = newQueue
	}
	return 0
}

//def BFS(graph, start, end):
//    visited = set()
//	queue = []
//	queue.append([start])
//
//	while queue:
//		node = queue.pop()
//		visited.add(node)
//
//		process(node)
//		nodes = generate_related_nodes(node)
//		queue.push(nodes)
//
//	# other processing work
//	...
