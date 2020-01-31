import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {

    private static final int[] X = {0, 1, 0, -1};
    private static final int[] Y = {-1, 0, 1, 0}; 
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        Trie cur = trie.perfix(word.charAt(0), trie);
                        char c = board[i][j];
                        board[i][j] = '*';
                        dfs("" + word.charAt(0) , word, cur, res, i, j, board);
                        board[i][j] = c;
                    }
                }
            }
        }
        return new ArrayList<String>(res);
    }

    // 有重复前缀的时候有问题
    // [["a","b"],["a","a"]]
// ["aa", "aba","baa","bab","aaab","aaa","aaaa","aaba"]
    private void dfs(String str, String target, Trie trie, Set<String> res, int i, int j, char[][] board) {
        if (str.equals(target)) {
            res.add(target);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + X[k];
            int y = j + Y[k];
            if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) continue;
            char c = board[x][y];
            if (c == '*') continue;
            Trie curTrie = trie.perfix(c, trie);
            if (curTrie == null) continue;
            board[x][y] = '*'; 
            dfs(str + c, target, curTrie, res, x, y, board);
            board[x][y] = c;
            str.substring(0, str.length() - 1);
        }      
    }

    class Trie {
        private Trie[] links;
        private static final int SIZE = 26;
        private boolean isEnd;

        public Trie() {
            this.links = new Trie[SIZE];
        }

        private void insert(String word) {
            Trie curTire = this;
            for (char c :  word.toCharArray()) {
                if (curTire.links[c - 'a'] == null) {
                    Trie trie = new Trie();
                    curTire.links[c - 'a'] = trie;
                    curTire = trie;
                } else {
                    curTire = curTire.links[c - 'a'];
                }
            }
            curTire.isEnd = true;
        }

        private Trie perfix(char c, Trie trie) {
            return trie.links[c - 'a'];
        }
    }
    
}

// @lc code=end

