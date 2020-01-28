class TrieNode {
    private TrieNode[] links;
    private int R = 26;
    private boolean isEnd;
    private String word;

    TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

class Trie {
    public TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd(true);
        node.setWord(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containKey(ch)) {
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }
}

class Solution {
public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0) {
            return res;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                existRecursive(i, j, board, trie.root, res);
            }
        }
        return res;
    }

    public void existRecursive(int row, int col, char[][] board, TrieNode node, List<String> res) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return;
        }

        char ch = board[row][col];
        if (ch == '#' || node.get(ch) == null) {
            return;
        }

        if (node.get(ch).isEnd()) {
            res.add(node.get(ch).getWord());
            node.get(ch).setEnd(false);
        }

        char tmp = board[row][col];
        board[row][col] = '#';
        existRecursive(row-1, col, board, node.get(tmp), res);
        existRecursive(row+1, col, board, node.get(tmp), res);
        existRecursive(row, col-1, board, node.get(tmp), res);
        existRecursive(row, col+1, board, node.get(tmp), res);
        board[row][col] = tmp;
    }

}
