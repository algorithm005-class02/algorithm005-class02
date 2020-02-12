package G20190343020289

//127. 单词接龙
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// 双向BFS
	// wordList中没有endWord的直接排除 返回0
	wordDic := make(map[string]bool)
	for _, word := range wordList {
		wordDic[word] = true
	}
	if _, ok := wordDic[endWord]; !ok {
		return 0
	}
	front := make(map[string]bool)
	back := make(map[string]bool)
	front[beginWord] = true
	back[endWord] = true
	level := 1
	wordLen := len(beginWord)
	for len(front) > 0 {
		level++
		next_front := make(map[string]bool)
		for word := range front {
			for i := 0; i < wordLen; i++ {
				for c := 'a'; c <= 'z'; c++ {
					newWord := word[:i] + string(c) + word[i+1:]
					if back[newWord] {
						return level
					}
					if wordDic[newWord] {
						next_front[newWord] = true
						wordDic[newWord] = false
					}
				}
			}
		}
		front = next_front
		if len(back) < len(front) {
			front, back = back, front
		}
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
