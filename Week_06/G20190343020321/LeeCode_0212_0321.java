import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II
 */
class LeeCode_0212_0321 {

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                          {'e', 't', 'a', 'e'},
                          {'i', 'h', 'k', 'r'},
                          {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> result = new Solution().findWords(board, words);
        result.forEach(System.out::println);
    }

    static class Solution {
        /**
         * findWords
         * 单词搜索 II
         */
        public List<String> findWords(char[][] board, String[] words) {
            //构建单词字典树
            WordTrie myTrie = new WordTrie();
            TrieNode root = myTrie.root;
            for (String s : words) {
                myTrie.insert(s);
            }

            // 剔除重复
            Set<String> result = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            // 遍历二维数组
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    find(board, visited, i, j, m, n, result, root);
                }
            }
            return new LinkedList<String>(result);
        }

        private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result, TrieNode cur) {

            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
                return;
            }
            cur = cur.child[board[i][j] - 'a'];
            visited[i][j] = true;

            if (cur == null) {
                visited[i][j] = false;
                return;
            }

            if (cur.isLeaf) {
                result.add(cur.val);

            }
            find(board, visited, i + 1, j, m, n, result, cur);
            find(board, visited, i, j + 1, m, n, result, cur);
            find(board, visited, i, j - 1, m, n, result, cur);
            find(board, visited, i - 1, j, m, n, result, cur);

            visited[i][j] = false;
        }


    }

    /**
     * 单词字典树
     */
    static class WordTrie {
        public TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                    cur = cur.child[c - 'a'];
                } else {
                    cur = cur.child[c - 'a'];
                }
            }
            cur.isLeaf = true;
            cur.val = s;
        }
    }

    /**
     * 字典树实体
     */
    static class TrieNode {
        public String val;
        public TrieNode[] child = new TrieNode[26];
        public boolean isLeaf = false;
    }

}


