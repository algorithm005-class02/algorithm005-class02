package leetcode.week06;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
public class LeetCode_208_实现Trie_0011 {

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
    }

}
