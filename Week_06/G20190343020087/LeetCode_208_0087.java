package LeetCode.week06.homework;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class TrieNode {
    private final int R = 26;
    private final TrieNode[] children;
    private String item;

    public TrieNode() {
        children = new TrieNode[R];
        item = "";
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChild(int i) {
        if (i >= 26 || i < 0)
            throw new IllegalArgumentException();
        return children[i];
    }

    public void setChild(int i, TrieNode node) {
        children[i] = node;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null)
                curr.setChild(c - 'a', new TrieNode());
            curr = curr.getChild(c - 'a');
        }
        curr.setItem(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c - 'a') == null)
                return false;
            curr = curr.getChild(c - 'a');
        }
        return curr.getItem().equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.getChild(c - 'a') == null)
                return false;
            curr = curr.getChild(c - 'a');
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
