/**
 * 实现Trie
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Leetcode_208_implementTrie {
    class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.containsKey(c)) {
                    cur.put(c, new TrieNode());
                }
                cur = cur.get(c);
            }
            cur.setEnd();
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }


        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);
            return node != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.containsKey(c)) {
                    cur = cur.get(c);
                } else {
                    return null;
                }
            }
            return cur;
        }
    }



    class TrieNode {
        private TrieNode[] links;
        private final int N = 26;
        private boolean isEnd;


        public TrieNode() {
            links = new TrieNode[N];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}


