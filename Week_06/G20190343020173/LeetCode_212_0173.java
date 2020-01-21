package org.crayzer.leetcode.editor.en.trie;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_WordSearch2 {

    class Solution {
        class TrieNode {
            public String val;
            public boolean isLeaf;
            public TrieNode[] links = new TrieNode[26];

            public TrieNode() {
            }
        }

        class WordTrie {
            public TrieNode root = new TrieNode();

            public void insert(String word) {
                TrieNode node = root;
                for (char ch : word.toCharArray()) {
                    if (node.links[ch - 'a'] == null) node.links[ch - 'a'] = new TrieNode();
                    node = node.links[ch - 'a'];
                }
                node.isLeaf = true;
                node.val = word;
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            WordTrie mytrie = new WordTrie();
            TrieNode root = mytrie.root;
            for (String word : words) {
                mytrie.insert(word);
            }

            Set<String> resultSet = new HashSet<>();
            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    find(board, visited, i, j, m, n, resultSet, root);
                }
            }
            return new LinkedList<>(resultSet);
        }

        private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> resultSet, TrieNode cur) {
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;

            cur = cur.links[board[i][j] - 'a'];
            visited[i][j] = true;
            if  (cur == null) {
                visited[i][j] = false;
                return;
            }

            if (cur.isLeaf) resultSet.add(cur.val);
            find(board, visited, i + 1, j, m, n, resultSet, cur);
            find(board, visited, i, j + 1, m, n, resultSet, cur);
            find(board, visited, i, j - 1, m, n, resultSet, cur);
            find(board, visited, i - 1, j, m, n, resultSet, cur);

            visited[i][j] = false;
        }
    }
}
