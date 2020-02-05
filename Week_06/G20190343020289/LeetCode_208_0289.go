package G20190343020289

// 208. 实现 Trie (前缀树)
type Trie struct {
	children [26]*Trie
	isEnd    bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{isEnd: true}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	root := this
	for i := 0; i < len(word); i++ {
		charIndex := int(word[i]) - int('a')
		if root.children[charIndex] == nil {
			root.children[charIndex] = new(Trie)
			root.children[charIndex].isEnd = false
		}
		root = root.children[charIndex]
	}
	root.isEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	return this.search(word, 1)
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	return this.search(prefix, 2)
}

func (root *Trie) search(str string, t int) bool {
	current := root
	for i := 0; i < len(str); i++ {
		charIndex := int(str[i]) - int('a')
		if current.children[charIndex] == nil {
			return false
		}
		current = current.children[charIndex]
	}
	if t == 1 {
		return current.isEnd
	} else {
		return true
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
