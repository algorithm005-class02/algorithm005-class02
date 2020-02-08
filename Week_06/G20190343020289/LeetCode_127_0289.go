package G20190343020289

//127. 单词接龙
func ladderLength(beginWord string, endWord string, wordList []string) int {
	// BFS
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
	for len(queue) > 0 {
		level++
		newQueue := queue[len(queue):]
		for _, item := range queue {
			for _, word := range wordList {
				diff := 0
				for i := 0; i < len(item); i++ {
					if item[i] != word[i] {
						diff++
					}
				}
				// 1个单词不一样
				if diff == 1 && !visited[word] {
					if word == endWord {
						return level + 1
					}
					visited[word] = true
					newQueue = append(newQueue, word)
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
