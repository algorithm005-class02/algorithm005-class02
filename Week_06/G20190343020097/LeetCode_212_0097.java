package G20190343020097;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  * @author jiangli
 *  * @date 2020/2/25 20:36
 *  * @description
 *  
 */
public class LeetCode_212_0097 {

    public List<String> findWords(char[][] board, String[] words) {

        Trie wordTrie = new Trie();
        for (String s : words) {
            wordTrie.insert(s);
        }

        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, "", wordTrie.root,  result);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    public void find(char[][] board, boolean[][] visited, int i, int j, String currentWord, TrieNode curNode, Set<String> result) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        char ch = board[i][j];
        curNode = curNode.get(ch);
        currentWord = currentWord + ch;
        visited[i][j] = true;
        if (curNode == null) {
            visited[i][j] = false;
            return;
        }
        if (curNode.isEnd()) {
            result.add(currentWord);
        }

        find(board, visited, i, j - 1, currentWord, curNode, result);
        find(board, visited, i, j + 1, currentWord, curNode, result);
        find(board, visited, i - 1, j, currentWord, curNode, result);
        find(board, visited, i + 1, j, currentWord, curNode, result);

        visited[i][j] = false;
    }
}
