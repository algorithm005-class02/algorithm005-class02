package org.crayzer.leetcode.editor.en.trie;

public class LeetCode_208_ImplementTrie {

    class TrieNode {
        private TrieNode[] links;
        private boolean isLeaf;
        private final int R = 26;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }

        public boolean isLeaf() {
            return this.isLeaf;
        }

        public void setLeaf() {
            this.isLeaf = true;
        }
    }

    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) node.put(ch, new TrieNode());
                node = node.get(ch);
            }
            node.setLeaf();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isLeaf();
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.containsKey(ch)) node = node.get(ch);
                else return null;
            }
            return node;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.containsKey(ch)) node = node.get(ch);
                else return false;
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
}

