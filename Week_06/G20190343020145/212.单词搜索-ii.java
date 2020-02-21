public class Solution {
    int[]dx = new int[]{-1,1,0,0};
    int[]dy = new int[]{0,0,-1,1};
    boolean[][] visited;
    Set<String> reslut = new HashSet<>();
    int row;
    int col;
    public List<String> findWords(char[][] board, String[] words){
        //构建Trie树
        Trie mytrie = new Trie();
        TrieNode root = mytrie.root;
        for(String s : words){
            mytrie.insert(s);
        }

        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        //遍历二维矩阵
        for(int i = 0;i < row; ++ i){
            for( int j = 0;j < col; ++ j){
                help(board, i, j, root);
            }
        }
        return new LinkedList<String>(reslut);
    }

    private void help(char[][] board, int i, int j, TrieNode curNode) {
        //Terminator
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j]){
            return;
        }

        //process
        curNode = curNode.get(board[i][j]);
        visited[i][j] = true;
        if(curNode == null){
            visited[i][j] = false;
            return;
        }
        if(curNode.isEnd()){
            reslut.add(curNode.val);
        }

        //drill down
        for(int k = 0;k < 4; ++ k){
            int di = dx[k] + i,dj = dy[k] + j;
            help(board, di, dj, curNode);
        }
        visited[i][j] = false;


    }
}

class Trie {
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length(); ++ i){
            char curChar = word.charAt(i);
            if(!node.ContainCh(curChar)){
                node.put(curChar,new TrieNode());
            }
            node = node.get(curChar);
        }
        node.setEnd();
        node.val = word;
    }
    public  TrieNode searchPre(String word){
        TrieNode node = root;
        for(int i = 0;i < word.length(); ++ i){
            char curChar = word.charAt(i);
            if(node.ContainCh(curChar)){
                node = node.get(curChar);
            }else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPre(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix){
        TrieNode node = searchPre(prefix);
        return node != null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    public String val;
    public TrieNode(){
        links = new TrieNode[R];
    }
    public boolean ContainCh(char ch){
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void put(char ch,TrieNode node){
        links[ch - 'a'] = node;
    }
    public  void setEnd(){
        isEnd = true;
    }
    public  boolean isEnd(){
        return isEnd;
    }
}