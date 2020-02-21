/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {


    private Trie[] nodes;
    private final int R = 26;

    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Trie[R];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curTrie = this;
        for (char letter : word.toCharArray()) {
            if (curTrie.nodes[letter-'a'] == null) {
                Trie trie = new Trie();
                curTrie.nodes[letter-'a'] = trie;
                curTrie = trie;
            } else {
               curTrie =  curTrie.nodes[letter-'a'];
            }
        }
        curTrie.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.nodes[c - 'a'] != null) {
                trie = trie.nodes[c - 'a'];
            } else {
                return false;
            }
        }
        return trie.isEnd;       
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            if (trie.nodes[c - 'a'] != null) {
                trie = trie.nodes[c - 'a'];
            } else {
                return false;
            }
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

