type trieMap map[rune](interface{})

var endTag rune = []rune("#")[0]

type Trie struct {
	tMap trieMap
}

func Constructor() Trie {
	t := Trie{}
	t.tMap = trieMap{}
	return t
}

func (this *Trie) Insert(word string) {
	tMap := this.tMap
	for _, c := range word {
		if cMap, ok := tMap[c]; ok {
			tMap = cMap.(trieMap)
		} else {
			cMap = trieMap{}
			tMap[c] = cMap
			tMap = cMap.(trieMap)
		}
	}
	tMap[endTag] = true
}

func (this *Trie) Search(word string) bool {
	tMap := this.tMap
	for _, c := range word {
		if cMap, ok := tMap[c]; ok {
			tMap = cMap.(trieMap)
		} else {
			return false
		}
	}
	_, ok := tMap[endTag]
	return ok
}

func (this *Trie) StartsWith(prefix string) bool {
	tMap := this.tMap
	for _, c := range prefix {
		if cMap, ok := tMap[c]; ok {
			tMap = cMap.(trieMap)
		} else {
			return false
		}
	}
	return true
}

