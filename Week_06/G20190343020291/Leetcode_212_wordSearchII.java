import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class Leetcode_212_wordSearchII {

    private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, m, n, board, root, visited, res);
            }
        }
        return res;
    }

    private void dfs(int i, int j, int m, int n, char[][] board, TrieNode node, boolean[][] visited, List<String> res) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return;
        }
        if (!node.containsKey(board[i][j])) {
            return;
        } else {
            node = node.get(board[i][j]);
            visited[i][j] = true;
            if (node.getWord() != null) {
                res.add(node.getWord());
                node.setWord(null);
            }
        }

        for (int[] tmp : dir) {
            dfs(i + tmp[0], j + tmp[1], m, n, board, node, visited, res);
        }
        visited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (!cur.containsKey(c)) {
                    cur.put(c, new TrieNode());
                }
                cur = cur.get(c);
            }
            cur.setWord(word);
        }
        return root;
    }

    class TrieNode {
        private TrieNode[] links;
        private final int N = 26;
        private String word;

        public TrieNode() {
            links = new TrieNode[N];
        }

        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            links[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return links[c - 'a'];
        }

        public void setWord(String w) {
            word = w;
        }

        public String getWord() {
            return word;
        }
    }

    public static void main(String[] args) {
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'a', 'a'}};
        String[] words = {"a"};
        Leetcode_212_wordSearchII solution = new Leetcode_212_wordSearchII();
        System.out.println(solution.findWords(board, words));
    }
}
