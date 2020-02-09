type Trie struct {
	isWordEnd bool
	next      [26]*Trie
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	for _, char := range word {
		if this.next[char-'a'] == nil {
			this.next[char-'a'] = new(Trie)
		}
		this = this.next[char-'a']
	}
	this.isWordEnd = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	for _, char := range word {
		if this.next[char-'a'] == nil {
			return false
		}
		this = this.next[char-'a']
	}
	return this.isWordEnd
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	for _, char := range prefix {
		if this.next[char-'a'] == nil {
			return false
		}
		this = this.next[char-'a']
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