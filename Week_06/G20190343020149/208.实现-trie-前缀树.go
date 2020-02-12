package leetcode

/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start

type trieMap map[rune](interface{})

var endTag rune = []rune("#")[0]

type Trie struct {
	tMap trieMap
}

/** Initialize your data structure here. */
func Constructor() Trie {
	t := Trie{}
	t.tMap = trieMap{}
	return t
}

/** Inserts a word into the trie. */
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

/** Returns if the word is in the trie. */
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

/** Returns if there is any word in the trie that starts with the given prefix. */
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

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end
