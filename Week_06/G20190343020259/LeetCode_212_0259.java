/**
 * Time Limit Exceeded ...
 */
class Solution {
    private Set<String> res = new HashSet<>();

    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length < 1) {
            return new ArrayList<>();
        }
        if (board == null || board.length < 1 || board[0].length < 1) {
            return new ArrayList<>();
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                this.backtrack(board, "", i, j, visited, trie);
            }
        }

        return new ArrayList<>(this.res);
    }

    public void backtrack(char[][] board, String word, int x, int y, boolean[][] visited, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        word += board[x][y];
        if (trie.search(word)) {
            this.res.add(word);
        }

        visited[x][y] = true;

        for (int[] dir : dirs) {
            this.backtrack(board, word, x+dir[0], y+dir[1], visited, trie);
        }

        visited[x][y] = false;
    }
}

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

    public static void main(String[] args) {
        String word1 = "apple";
        String word2 = "app";
        Trie trie = new Trie();
        System.out.println(trie.search(word1));
        System.out.println(trie.search(word2));
        trie.insert(word1);
        System.out.println(trie.search(word1));
        System.out.println(trie.search(word2));
        System.out.println(trie.startsWith(word2));
        trie.insert(word2);
        System.out.println(trie.search(word2));
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