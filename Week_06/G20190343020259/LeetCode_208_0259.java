class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int shift = ch - 'a';
            if (curr.children[shift] == null) {
                curr.children[shift] = new TrieNode();
            }
            curr = curr.children[shift];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode last = this.lastNode(word);
        return last != null && last.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode last = this.lastNode(prefix);
        return last != null;
    }

    private TrieNode lastNode(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int shift = ch - 'a';
            if (curr.children[shift] == null) {
                return null;
            }
            curr = curr.children[shift];
        }
        return curr;
    }

}