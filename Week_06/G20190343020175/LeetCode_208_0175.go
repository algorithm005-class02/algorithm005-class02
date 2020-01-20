package main

// Trie type define
type Trie struct {
	Nexts map[rune]*Trie
	IsEnd bool
}

// Constructor Initialize your data structure here.
func Constructor() Trie {
	return Trie{make(map[rune]*Trie), false}
}

// Insert inserts a word into the trie.
func (t *Trie) Insert(word string) {
	node := t
	for _, c := range word {
		if _, ok := node.Nexts[c]; !ok {
			node.Nexts[c] = &Trie{make(map[rune]*Trie), false}
		}
		node = node.Nexts[c]
	}
	node.IsEnd = true
}

// Search returns if the word is in the trie.
func (t *Trie) Search(word string) bool {
	node := t
	for _, c := range word {
		if _, ok := node.Nexts[c]; !ok {
			return false
		}
		node = node.Nexts[c]
	}
	return node.IsEnd
}

// StartsWith returns if there is any word in the trie that starts with the given prefix.
func (t *Trie) StartsWith(prefix string) bool {
	node := t
	for _, c := range prefix {
		if _, ok := node.Nexts[c]; !ok {
			return false
		}
		node = node.Nexts[c]
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
