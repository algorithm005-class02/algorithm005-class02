package main

type Trie struct {
	child [26]*Trie // 仅限小写字母，根据不同的场景做调整
	end   bool
}

func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	cur := this
	for i := 0; i < len(word); i++ {
		if cur.child[word[i]-'a'] == nil {
			cur.child[word[i]-'a'] = &Trie{}
		}
		cur = cur.child[word[i]-'a'] // 往下探
	}
	cur.end = true
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	cur := this
	for i := 0; i < len(word); i++ {
		if cur.child[word[i]-'a'] == nil {
			return false
		}
		cur = cur.child[word[i]-'a']
	}
	return cur.end
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	cur := this
	for i := 0; i < len(prefix); i++ {
		if cur.child[prefix[i]-'a'] == nil {
			return false
		}
		cur = cur.child[prefix[i]-'a']
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