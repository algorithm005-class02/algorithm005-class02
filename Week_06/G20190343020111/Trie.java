package com.solution;
/*208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 */
public class Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		boolean r1 = trie.search("apple"); // 返回 true
		boolean r2 = trie.search("app"); // 返回 false
		boolean r3 = trie.startsWith("app"); // 返回 true
		trie.insert("app");
		boolean r4 = trie.search("app"); // 返回 true

		System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);

	}

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			if (!node.containKey(c)) {
				node.put(c, new TrieNode());
			}
			node = node.get(c);
		}
		node.setEnd();

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			char c = word.charAt(i);
			if (!node.containKey(c)) {
				return false;
			}
			node = node.get(c);
		}
		return node.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		int len = prefix.length();
		for (int i = 0; i < len; i++) {
			char c = prefix.charAt(i);
			if (!node.containKey(c)) {
				return false;
			}
			node = node.get(c);
		}
		return true;
	}

	class TrieNode {
		private TrieNode links[];
		static private final int R = 26;
		private boolean isEnd;

		public TrieNode() {
			links = new TrieNode[R];
		}

		public void put(char c, TrieNode node) {
			links[c - 'a'] = node;
		}

		public TrieNode get(char c) {
			return links[c - 'a'];
		}

		public boolean containKey(char c) {
			return links[c - 'a'] != null;
		}

		public void setEnd() {
			isEnd = true;
		}
	}
}
