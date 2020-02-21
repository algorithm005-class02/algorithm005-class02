import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //构建字典树
        WordTrie myTire = new WordTrie();
        TrieNode node = myTire.root;
        for (String s:words) {
            myTire.insert(s);
        }

        //使用Set防止重复
        Set<String> result = new HashSet<String>();
        //二维网格的高和宽
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //遍历整个二维数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board,visited,i,j,m,n,result,node);
            }
        }
        System.out.println(result);
        return new LinkedList<String>(result);
    }
    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, Set<String> result,TrieNode node){
        // terminator
        //边界以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        node = node.children[board[i][j] - 'a'];
        visited[i][j] = true;
        if (node == null) {
            //如果单词不匹配，回退
            visited[i][j] = false;
            return;
        }


        // process current logic
        //找到单词加入
        if (node.isLeaf) {
            result.add(node.val);
            //找到单词后不能回退，因为可能是“ad” “addd”这样的单词得继续回溯
        }

        // drill down
        find(board,visited,i + 1,j,m,n,result,node);
        find(board,visited,i,j + 1,m,n,result,node);
        find(board,visited,i - 1,j,m,n,result,node);
        find(board,visited,i,j - 1,m,n,result,node);

        // reverse states
        //最后要回退，因为下一个起点可能会用到上一个起点的字符
        visited[i][j] = false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 字典树
 */
class WordTrie {
    public TrieNode root;

    public WordTrie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode node = root;
        for (char ch: s.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isLeaf = true;
        node.val = s;
    }

}

/**
 * 字典树节点
 */
class TrieNode {
    public String val;
    public TrieNode[] children;
    public boolean isLeaf = false;

    public TrieNode() {
        children = new TrieNode[26];
    }
}