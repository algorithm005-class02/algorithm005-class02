package G20190343020289

// 208. 实现 Trie (前缀树)
type Trie struct {
	val      byte
	children [26]*Trie
	isEnd    bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	root := this
	for i := 0; i < len(word); i++ {
		charIndex := int(word[i]) - int('a')
		if root.children[charIndex] == nil {
			var zz Trie
			zz.val = word[i]
			root.children[charIndex] = &zz
		}
		root = root.children[charIndex]
		if i == len(word)-1 {
			root.isEnd = true
		}
	}
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	root := this
	for i := 0; i < len(word); i++ {
		charIndex := int(word[i]) - int('a')
		if root.children[charIndex] == nil {
			return false
		}
		root = root.children[charIndex]
		if i == len(word)-1 && !root.isEnd {
			return false
		}
	}
	return true
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	root := this
	for i := 0; i < len(prefix); i++ {
		charIndex := int(prefix[i]) - int('a')
		if root.children[charIndex] == nil {
			return false
		}
		root = root.children[charIndex]
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
